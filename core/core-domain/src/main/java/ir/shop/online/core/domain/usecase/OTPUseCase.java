package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.otp.OTP;
import ir.shop.online.core.domain.model.otp.OTPType;

public interface OTPUseCase {
    String generateOTP(String identifier, OTPType type);

    boolean verifyOTP(String identifier, String code, OTPType type);

    OTP getOTP(String identifier);

    void deleteOTP(String identifier);
}
