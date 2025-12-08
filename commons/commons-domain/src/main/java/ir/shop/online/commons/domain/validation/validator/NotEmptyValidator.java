package ir.shop.online.commons.domain.validation.validator;

import ir.shop.online.commons.domain.validation.NotEmpty;
import ir.shop.online.commons.domain.exception.DomainValidationException;

public class NotEmptyValidator implements AnnotationValidator<String, NotEmpty> {

    @Override
    public void validate(String value, NotEmpty NotEmpty, String paramName) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainValidationException("NotEmptyValidator-01", paramName);
        }
    }
}
