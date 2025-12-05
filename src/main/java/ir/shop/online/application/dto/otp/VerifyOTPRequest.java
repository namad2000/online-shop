package ir.shop.online.application.dto.otp;

import lombok.Data;

@Data
public class VerifyOTPRequest {
    private String identifier;
    private String code;
    private OTPType type;
}
