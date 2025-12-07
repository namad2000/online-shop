package ir.shop.online.commons.domain.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends DomainException {

    public ValidationException(String code, String message) {
        super(code, message);
    }

    public ValidationException(String code, String message, HttpStatus httpStatus) {
        super(code, message, httpStatus);
    }
}