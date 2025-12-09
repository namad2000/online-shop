package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.property.Property;
import ir.shop.online.core.domain.model.otp.OTP;
import ir.shop.online.core.domain.model.otp.OTPType;
import ir.shop.online.core.domain.repository.memory.OtpRepository;
import ir.shop.online.core.domain.usecase.OTPUseCase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static ir.shop.online.core.domain.exception.ExceptionCode.*;

@UseCaseService
@RequiredArgsConstructor
public class OTPUseCaseAdapter implements OTPUseCase {

    @Property(key = "otp.expiration-time", defaultValue = "3000")
    private long expirationTime;

    @Property(key = "otp.max-attempts", defaultValue = "10")
    private int maxAttempts; //TODO: بیزنس تعداد تلاش های ناموفق نوشته شود

    @Property(key = "otp.resend-cooldown", defaultValue = "3000")
    private long resendCooldown;//TODO: بیزنس تعداد تلاش های ناموفق نوشته شود

    private final OtpRepository otpRepository;

    @Override
    public String generateOTP(String identifier, OTPType type) {

        boolean exists = otpRepository.existsByIdentifier(identifier);
        if (!exists) {
            throw new DomainException(OTP_05.name());
        }

        // Delete previous OTP if it exists
        otpRepository.deleteByIdentifier(identifier);

        LocalDateTime now = LocalDateTime.now();
        OTP otp = OTP.builder()
                .identifier(identifier)
                .createdAt(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .type(type)
                .build();


        otpRepository.saveByIdentifier(identifier, otp, expirationTime, TimeUnit.SECONDS);
        otpRepository.saveCooldown(identifier, otp, resendCooldown, TimeUnit.SECONDS);

        return otp.getCode();
    }

    // OTP validation
    @Override
    public boolean verifyOTP(String identifier, String code, OTPType type) {
        OTP otp = otpRepository.findByIdentifier(identifier);

        if (otp == null) {
            throw new DomainException(OTP_01.name());
        }

        if (otp.getAttempts() >= maxAttempts) {
            otpRepository.deleteByIdentifier(identifier);
            throw new DomainException(OTP_02.name());
        }

        if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            otpRepository.deleteByIdentifier(identifier);
            throw new DomainException(OTP_03.name());
        }

        if (otp.getType() != type) {
            throw new DomainException(OTP_04.name());
        }

        if (otp.getCode().equals(code)) {
            otpRepository.deleteByIdentifier(identifier);
            return true;
        } else {
            increseAttermptsAndSave(identifier, otp);
            return false;
        }
    }

    // بررسی وجود OTP
    @Override
    public OTP getOTP(String identifier) {
        return otpRepository.findByIdentifier(identifier);
    }

    // حذف OTP
    @Override
    public void deleteOTP(String identifier) {
        otpRepository.deleteByIdentifier(identifier);
    }

    private void increseAttermptsAndSave(String identifier, OTP otp) {
        // Increase attempt count
        otp.setAttempts(otp.getAttempts() + 1);

        // Save with updated attempt count
        long ttl = otpRepository.getExpireByIdentifier(identifier);
        if (ttl > 0) {
            otpRepository.saveByIdentifier(identifier, otp, ttl, TimeUnit.SECONDS);
        }
    }
}
