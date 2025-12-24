package ir.shop.online.core.domain.exception;


public enum ExceptionCode {
    OTP_01("My OTP code has expired or does not exist."),
    OTP_02("The number of attempts exceeds the allowed limit"),
    OTP_03("My OTP code has expired"),
    OTP_04("Invalid OTP type"),
    OTP_05("Please wait before requesting again"),
    ADDRESS_01("Address not found"),
    ADDRESS_02("Address title is duplicate"),
    ADDRESS_03("Address not belong to user"),
    USER_01("User not found"),
    USER_02("User exist now"),
    ROLE_01("Role not found"),
    CATEGORY_01("Category not found"),
    CATEGORY_02("Category is duplicate"),
    CATEGORY_03("Only '1' Category can exist without parent"),
    CATEGORY_04("Parent is invalid"),
    CATEGORY_05 ( "Cycle not allowed"),
    PRODUCT_01("Product exist in category"),
    PRODUCT_012("Product not found");

    private final String description;

    ExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
