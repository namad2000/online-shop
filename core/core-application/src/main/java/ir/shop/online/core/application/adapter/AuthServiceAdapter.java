package ir.shop.online.core.application.adapter;

import ir.shop.online.application.dto.otp.OTPType;
import ir.shop.online.application.service.OTPService;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.AuthUseCase;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class AuthServiceAdapter implements AuthUseCase {

    private final OTPService otpService;

    @Override
    public void requestLoginOTP(String mobile) {
        String code = otpService.generateOTP(mobile, OTPType.LOGIN);
//        // ارسال SMS
//        smsService.sendSMS(mobile, "کد ورود شما: " + code);
        System.out.println(mobile + ":" + code);
    }

    @Override
    public boolean verifyLoginOTP(String mobile, String code) {
        boolean isValid = otpService.verifyOTP(mobile, code, OTPType.LOGIN);

        if (isValid) {

        }
        return isValid;
    }
}
