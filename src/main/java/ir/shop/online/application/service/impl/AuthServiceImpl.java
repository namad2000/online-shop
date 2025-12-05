package ir.shop.online.application.service.impl;

import ir.shop.online.application.dto.otp.OTPType;
import ir.shop.online.application.service.AuthService;
import ir.shop.online.application.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final OTPService otpService;

    @Override
    public void requestLoginOTP(String mobile) {
        String code = otpService.generateOTP(mobile, OTPType.LOGIN);
//        // ارسال SMS
//        smsService.sendSMS(mobile, "کد ورود شما: " + code);
        System.out.println(mobile + ":" + code);
    }

    @Override
    public void verifyLoginOTP(String mobile, String code) {
        boolean isValid =  otpService.verifyOTP(mobile, code, OTPType.LOGIN);

        if (isValid) {

        }
    }
}
