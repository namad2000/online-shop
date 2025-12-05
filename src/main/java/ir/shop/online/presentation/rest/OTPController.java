package ir.shop.online.presentation.rest;

import ir.shop.online.application.dto.otp.OTPType;
import ir.shop.online.application.dto.otp.VerifyOTPRequest;
import ir.shop.online.application.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OTPController {

    private final OTPService otpService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateOTP(
            @RequestParam String identifier,
            @RequestParam OTPType type) {
        try {
            String code = otpService.generateOTP(identifier, type);
            // TODO: ارسال کد از طریق ایمیل یا SMS
            // emailService.sendOTP(identifier, code);

            return ResponseEntity.ok().body(
                    Map.of(
                            "message", "کد OTP ارسال شد",
                            "identifier", identifier,
                            "type", type
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOTP(
            @RequestBody VerifyOTPRequest request) {
        try {

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }
}
