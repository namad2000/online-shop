package ir.shop.online.domain.exception;


public enum ExceptionCode {
    OTP_01("My OTP code has expired or does not exist."),
    OTP_02("The number of attempts exceeds the allowed limit"),
    OTP_03("My OTP code has expired"),
    OTP_04("Invalid OTP type"),
    OTP_05("Please wait before requesting again"),
    ADDRESS_01("Address title is duplicate"),
    ADDRESS_02("Address not found"),
    ADDRESS_03("Address not belong to user"),
    USER_01("User exist now"),
    USER_02("User not found"),
    ROLE_01("Role not exist"),
    CATEGORY_01("Category is duplicate"),
    CATEGORY_02("Category not found"),
    CATEGORY_03("Category not exist"),
    CATEGORY_04("Only 1 Category can without parent"),
    PRODUCT_01("Product exist in category"),
    PRODUCT_02("Product not found");

    private final String description;

    ExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
