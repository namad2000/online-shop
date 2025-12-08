package ir.shop.online.core.domain.model.otp;

import lombok.Data;

@Data
public class VerifyOTPRequest {
    private String identifier;
    private String code;
    private OTPType type;
}
