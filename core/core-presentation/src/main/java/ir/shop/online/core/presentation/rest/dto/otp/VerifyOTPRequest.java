package ir.shop.online.core.presentation.rest.dto.otp;

import lombok.Data;

@Data
public class VerifyOTPRequest {
    private String identifier;
    private String code;
    private OTPType type;
}
