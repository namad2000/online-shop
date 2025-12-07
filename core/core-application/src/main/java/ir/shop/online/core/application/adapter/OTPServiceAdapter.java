package ir.shop.online.core.application.adapter;

import ir.shop.online.application.dto.otp.OTP;
import ir.shop.online.application.dto.otp.OTPType;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.OTPUseCase;
import ir.shop.online.domain.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static ir.shop.online.domain.exception.ExceptionCode.*;

@UseCaseService
@RequiredArgsConstructor
public class OTPServiceAdapter implements OTPUseCase {

    private final RedisTemplate<String, OTP> redisTemplate;

    @Value("${otp.expiration-time}")
    private int expirationTime;

    @Value("${otp.max-attempts}")
    private int maxAttempts;

    @Value("${otp.resend-cooldown}")
    private int resendCooldown;

    private static final String OTP_PREFIX = "otp:";
    private static final String OTP_COOLDOWN_PREFIX = "otp_cooldown:";
    private static final Random random = new Random();


    // تولید کد OTP
    @Override
    public String generateOTP(String identifier, OTPType type) {
        // بررسی کول‌داون برای ارسال مجدد
        String cooldownKey = OTP_COOLDOWN_PREFIX + identifier;
        if (Boolean.TRUE.equals(redisTemplate.hasKey(cooldownKey))) {
            throw new DomainException(OTP_05);
        }

        // حذف OTP قبلی اگر وجود دارد
        String oldKey = OTP_PREFIX + identifier;
        redisTemplate.delete(oldKey);

        // تولید کد 6 رقمی
        String code = String.format("%06d", random.nextInt(999999));

        // ایجاد شیء OTP
        LocalDateTime now = LocalDateTime.now();
        OTP otp = new OTP(
                code,
                identifier,
                type,
                0,
                now,
                now.plusSeconds(expirationTime),
                false
        );

        // ذخیره در Redis
        String key = OTP_PREFIX + identifier;
        redisTemplate.opsForValue().set(key, otp, expirationTime, TimeUnit.SECONDS);

        // تنظیم کول‌داون
        redisTemplate.opsForValue().set(
                cooldownKey,
                otp,
                resendCooldown,
                TimeUnit.SECONDS
        );

        return code;
    }

    // اعتبارسنجی OTP
    @Override
    public boolean verifyOTP(String identifier, String code, OTPType type) {
        String key = OTP_PREFIX + identifier;
        OTP otp = redisTemplate.opsForValue().get(key);

        if (otp == null) {
            throw new DomainException(OTP_01);
        }

        if (otp.getAttempts() >= maxAttempts) {
            redisTemplate.delete(key);
            throw new DomainException(OTP_02);
        }

        if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            redisTemplate.delete(key);
            throw new DomainException(OTP_03);
        }

        if (otp.getType() != type) {
            throw new DomainException(OTP_04);
        }

        // افزایش تعداد تلاش‌ها
        otp.setAttempts(otp.getAttempts() + 1);

        if (otp.getCode().equals(code)) {
            otp.setVerified(true);
            redisTemplate.delete(key);
            return true;
        } else {
            // ذخیره با تعداد تلاش‌های به‌روز شده
            long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            if (ttl > 0) {
                redisTemplate.opsForValue().set(key, otp, ttl, TimeUnit.SECONDS);
            }
            return false;
        }
    }

    // بررسی وجود OTP
    @Override
    public OTP getOTP(String identifier) {
        String key = OTP_PREFIX + identifier;
        return redisTemplate.opsForValue().get(key);
    }

    // حذف OTP
    @Override
    public void deleteOTP(String identifier) {
        String key = OTP_PREFIX + identifier;
        redisTemplate.delete(key);
    }
}
