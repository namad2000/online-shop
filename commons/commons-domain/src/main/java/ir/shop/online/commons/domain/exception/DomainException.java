package ir.shop.online.commons.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class DomainException extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;

    public DomainException(String code, String message) {
        this(code, message, HttpStatus.BAD_REQUEST);
    }

    public DomainException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
