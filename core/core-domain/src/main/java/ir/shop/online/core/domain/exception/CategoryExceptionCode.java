package ir.shop.online.core.domain.exception;


public enum CategoryExceptionCode {

    CATEGORY_01("Category not found"),
    CATEGORY_02("Category is duplicate"),
    CATEGORY_03("Only '1' Category can exist without parent"),
    CATEGORY_04("Parent is invalid"),
    CATEGORY_05("Cycle not allowed");

    private final String description;

    CategoryExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
