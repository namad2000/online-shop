package ir.shop.online.commons.domain.exception;

import lombok.Getter;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Getter
public class DomainBusinessException extends DomainException {

    public DomainBusinessException(String code) {
        super(code);
    }

    public DomainBusinessException(String code, int httpStatus) {
        super(code, httpStatus);
    }

    public DomainBusinessException(String code, String message) {
        super(code, message);
    }

    public DomainBusinessException(String code, String message, int httpStatus) {
        super(code, message, httpStatus);
    }
}
