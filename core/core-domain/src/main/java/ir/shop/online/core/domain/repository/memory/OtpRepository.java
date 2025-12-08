package ir.shop.online.core.domain.repository.memory;

import ir.shop.online.core.domain.model.otp.OTP;

import java.util.concurrent.TimeUnit;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/8/2025 8:52 PM
 * Package: ir.shop.online.core.domain.repository.redis
 */

public interface OtpRepository {

    String OTP_PREFIX = "otp:";
    String OTP_COOLDOWN_PREFIX = "otp_cooldown:";

    boolean existsByIdentifier(String identifier);

    OTP findByIdentifier(String identifier);

    void saveByIdentifier(String identifier, OTP otp, long expirationTime, TimeUnit expirationTimeUnit);

    void saveCooldown(String identifier, OTP otp, long resendCooldown, TimeUnit expirationTimeUnit);

    void deleteByIdentifier(String identifier);

    long getExpireByIdentifier(String identifier);
}
