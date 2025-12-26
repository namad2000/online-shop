package ir.shop.online.core.domain.exception;


public enum ProductExceptionCode {

    PRODUCT_01("Product not found"),
    PRODUCT_02("Product exist in category");

    private final String description;

    ProductExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
