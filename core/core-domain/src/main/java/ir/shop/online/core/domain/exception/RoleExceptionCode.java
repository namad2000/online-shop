package ir.shop.online.core.domain.exception;


public enum RoleExceptionCode {

    ROLE_01("Role not found");

    private final String description;

    RoleExceptionCode(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
