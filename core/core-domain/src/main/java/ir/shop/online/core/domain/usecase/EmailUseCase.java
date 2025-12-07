package ir.shop.online.core.domain.usecase;

public interface EmailUseCase {
    void sendOTP(String email, String code);
}
