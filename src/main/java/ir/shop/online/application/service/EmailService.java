package ir.shop.online.application.service;

public interface EmailService {
    void sendOTP(String email, String code);
}
