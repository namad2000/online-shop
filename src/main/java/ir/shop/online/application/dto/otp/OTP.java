package ir.shop.online.application.dto.otp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTP {
    private String code;
    private String identifier; // ایمیل یا شماره موبایل
    private OTPType type;
    private int attempts;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private boolean verified;
}


