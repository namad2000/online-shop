package ir.shop.online.core.domain.model.otp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OTP {

    @Builder.Default
    private Random random = new Random();

    @Builder.Default
    private String code = String.format("%06d", random.nextInt(999999));
    private String identifier; // ایمیل یا شماره موبایل
    private OTPType type;

    @Builder.Default
    private int attempts = 0;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}


