package ir.shop.online.commons.domain.exception;

import lombok.Getter;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Getter
public class DomainValidationException extends DomainException {
    protected String paramName;

    public DomainValidationException(String code, String paramName) {
        super(code, 400);
        this.paramName = paramName;
    }
}
