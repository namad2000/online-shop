package ir.online.shop.application.port.in.usecase;


import io.qoop.filter.bean.api.UseCaseService;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class AuthUseCase {

//    private final OTPUseCase otpUseCase;
//
//    @Override
//    public void requestLoginOTP(String mobile) {
//        String code = otpUseCase.generateOTP(mobile, OTPType.LOGIN);
////        // ارسال SMS
////        smsService.sendSMS(mobile, "کد ورود شما: " + code);
//        System.out.println(mobile + ":" + code);
//    }
//
//    @Override
//    public boolean verifyLoginOTP(String mobile, String code) {
//        boolean isValid = otpUseCase.verifyOTP(mobile, code, OTPType.LOGIN);
//
//        if (isValid) {
//
//        }
//        return isValid;
//    }
}
