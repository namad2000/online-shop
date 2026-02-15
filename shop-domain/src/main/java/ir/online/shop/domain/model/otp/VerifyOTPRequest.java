package ir.online.shop.domain.model.otp;

import lombok.Data;

@Data
public class VerifyOTPRequest {
    private String identifier;
    private String code;
    private OTPType type;
}
