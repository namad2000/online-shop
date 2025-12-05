package ir.shop.online.application.service;

public interface AuthService {
    void requestLoginOTP(String mobile);

    boolean verifyLoginOTP(String mobile, String code);
}
