package ir.shop.online.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class DomainException extends RuntimeException {
    private final ExceptionCode code;
    private final HttpStatus httpStatus;

    public DomainException(ExceptionCode code) {
        this(code, code.description(), HttpStatus.BAD_REQUEST);
    }


    public DomainException(ExceptionCode code, String message) {
        this(code, message, HttpStatus.BAD_REQUEST);
    }

    public DomainException(ExceptionCode code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
