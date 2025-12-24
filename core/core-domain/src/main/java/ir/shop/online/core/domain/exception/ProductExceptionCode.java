package ir.shop.online.core.domain.exception;


public enum ProductExceptionCode {

    PRODUCT_01("Product exist in category"),
    PRODUCT_02("Product not found");

    private final String description;

    ProductExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
