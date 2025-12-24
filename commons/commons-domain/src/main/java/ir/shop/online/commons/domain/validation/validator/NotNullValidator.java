package ir.shop.online.commons.domain.validation.validator;

import ir.shop.online.commons.domain.exception.DomainValidationException;
import ir.shop.online.commons.domain.validation.NotNull;

public class NotNullValidator implements AnnotationValidator<Object, NotNull> {

    @Override
    public void validate(Object value, NotNull notNull, String paramName) {
        if (value == null) {
            throw new DomainValidationException("NotNullValidator-01", paramName);
        }
    }
}
