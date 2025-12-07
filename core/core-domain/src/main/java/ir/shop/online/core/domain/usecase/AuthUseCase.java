package ir.shop.online.core.domain.usecase;

public interface AuthUseCase {
    void requestLoginOTP(String mobile);

    boolean verifyLoginOTP(String mobile, String code);
}
