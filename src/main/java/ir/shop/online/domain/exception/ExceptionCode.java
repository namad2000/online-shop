package ir.shop.online.domain.exception;


public enum ExceptionCode {
    OTP_01("My OTP code has expired or does not exist."),
    OTP_02("The number of attempts exceeds the allowed limit"),
    OTP_03("My OTP code has expired"),
    OTP_04("Invalid OTP type"),
    OTP_05("Please wait before requesting again");

    private final String description;

    ExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
