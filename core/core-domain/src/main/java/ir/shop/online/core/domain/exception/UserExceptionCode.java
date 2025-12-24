package ir.shop.online.core.domain.exception;


public enum UserExceptionCode {

    USER_01("User not found"),
    USER_02("User exist now");

    private final String description;

    UserExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
