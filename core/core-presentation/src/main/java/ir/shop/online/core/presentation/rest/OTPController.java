//package ir.shop.online.core.presentation.rest;
//
//
//import ir.shop.online.core.domain.model.otp.OTPType;
//import ir.shop.online.core.domain.model.otp.VerifyOTPRequest;
//import ir.shop.online.core.domain.usecase.OTPUseCase;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/otp")
//@RequiredArgsConstructor
//public class OTPController {
//
//    private final OTPUseCase otpUseCase;
//
//    @PostMapping("/generate")
//    public ResponseEntity<?> generateOTP(
//            @RequestParam String identifier,
//            @RequestParam OTPType type) {
//        try {
//            String code = otpUseCase.generateOTP(identifier, type);
//            // TODO: ارسال کد از طریق ایمیل یا SMS
//            // emailService.sendOTP(identifier, code);
//
//            return ResponseEntity.ok().body(
//                    Map.of(
//                            "message", "کد OTP ارسال شد",
//                            "identifier", identifier,
//                            "type", type
//                    )
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("error", e.getMessage())
//            );
//        }
//    }
//
//    @PostMapping("/verify")
//    public ResponseEntity<?> verifyOTP(
//            @RequestBody VerifyOTPRequest request) {
//        try {
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("error", e.getMessage())
//            );
//        }
//    }
//}
