package ir.online.shop.application.port.in.usecase;


import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.property.api.Property;
import ir.online.shop.domain.model.otp.OTP;
import ir.online.shop.domain.model.otp.OTPType;
import ir.online.shop.domain.repository.memory.OtpRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static ir.online.shop.domain.exception.OTPExceptionCode.*;

@UseCaseService
@RequiredArgsConstructor
public class OTPUseCase {

    @Property(key = "otp.expiration-time", defaultValue = "3000")
    private long expirationTime;

    @Property(key = "otp.max-attempts", defaultValue = "10")
    private int maxAttempts; //TODO: بیزنس تعداد تلاش های ناموفق نوشته شود

    @Property(key = "otp.resend-cooldown", defaultValue = "3000")
    private long resendCooldown;//TODO: بیزنس تعداد تلاش های ناموفق نوشته شود

    private final OtpRepository otpRepository;

    public String generateOTP(String identifier, OTPType type) {

        boolean exists = otpRepository.existsByIdentifier(identifier);
        if (!exists) {
            throw DomainException.of(OTP_05.name());
        }

        // Delete previous OTP if it exists
        otpRepository.deleteByIdentifier(identifier);

        OTP otp = generateOtp(identifier, type);
        otpRepository.saveByIdentifier(identifier, otp, expirationTime, TimeUnit.SECONDS);
        otpRepository.saveCooldown(identifier, otp, resendCooldown, TimeUnit.SECONDS);

        return otp.getCode();
    }

    // OTP validation
    public boolean verifyOTP(String identifier, String code, OTPType type) {
        OTP otp = otpRepository.findByIdentifier(identifier);

        if (otp == null) {
            throw DomainException.of(OTP_01.name());
        }

        if (otp.getAttempts() >= maxAttempts) {
            otpRepository.deleteByIdentifier(identifier);
            throw DomainException.of(OTP_02.name());
        }

        if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            otpRepository.deleteByIdentifier(identifier);
            throw DomainException.of(OTP_03.name());
        }

        if (otp.getType() != type) {
            throw DomainException.of(OTP_04.name());
        }

        if (otp.getCode().equals(code)) {
            otpRepository.deleteByIdentifier(identifier);
            return true;
        } else {
            increseAttermptsAndSave(identifier, otp);
            return false;
        }
    }

    // Check for the existence of OTP
    public OTP getOTP(String identifier) {
        return otpRepository.findByIdentifier(identifier);
    }

    // Delete OTP
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

    private OTP generateOtp(String identifier, OTPType type) {
        Random random = new Random();
        String code = String.format("%06d", random.nextInt(999999));
        LocalDateTime now = LocalDateTime.now();
        return OTP.builder()
                .identifier(identifier)
                .code(code)
                .createdAt(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .type(type)
                .build();
    }
}
