package ir.shop.online.commons.domain.exception;

import lombok.Getter;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Getter
public class DomainException extends RuntimeException {
    protected final String code;
    protected int httpStatus = 400;

    public DomainException(String code) {
        this.code = code;
    }

    public DomainException(String code, int httpStatus) {
        this(code);
        this.httpStatus = httpStatus;
    }

    public DomainException(String code, String message) {
        super(message);
        this.code = code;
    }

    public DomainException(String code, String message, int httpStatus) {
        this(code, message);
        this.httpStatus = httpStatus;
    }
}
