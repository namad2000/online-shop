package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.model.otp.OTPType;
import ir.shop.online.core.domain.usecase.AuthUseCase;
import ir.shop.online.core.domain.usecase.OTPUseCase;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class AuthServiceAdapter implements AuthUseCase {

    private final OTPUseCase otpUseCase;

    @Override
    public void requestLoginOTP(String mobile) {
        String code = otpUseCase.generateOTP(mobile, OTPType.LOGIN);
//        // ارسال SMS
//        smsService.sendSMS(mobile, "کد ورود شما: " + code);
        System.out.println(mobile + ":" + code);
    }

    @Override
    public boolean verifyLoginOTP(String mobile, String code) {
        boolean isValid = otpUseCase.verifyOTP(mobile, code, OTPType.LOGIN);

        if (isValid) {

        }
        return isValid;
    }
}
