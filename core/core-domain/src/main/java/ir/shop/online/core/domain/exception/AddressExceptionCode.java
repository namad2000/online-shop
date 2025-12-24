package ir.shop.online.core.domain.exception;


public enum AddressExceptionCode {

    ADDRESS_01("Address not found"),
    ADDRESS_02("Address title is duplicate"),
    ADDRESS_03("Address not belong to user");

    private final String description;

    AddressExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
