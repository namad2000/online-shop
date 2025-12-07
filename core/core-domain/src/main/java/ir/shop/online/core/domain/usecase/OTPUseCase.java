package ir.shop.online.core.domain.usecase;

import ir.shop.online.application.dto.otp.OTP;
import ir.shop.online.application.dto.otp.OTPType;

public interface OTPUseCase {
    String generateOTP(String identifier, OTPType type);

    boolean verifyOTP(String identifier, String code, OTPType type);

    public OTP getOTP(String identifier);

    void deleteOTP(String identifier);
}
