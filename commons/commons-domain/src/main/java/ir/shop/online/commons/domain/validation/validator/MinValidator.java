package ir.shop.online.commons.domain.validation.validator;

import ir.shop.online.commons.domain.exception.DomainValidationException;
import ir.shop.online.commons.domain.validation.Min;

public class MinValidator implements AnnotationValidator<Number, Min> {
    @Override
    public void validate(Number value, Min annotation, String paramName) {
        if (value != null && value.longValue() < annotation.value()) {
            throw new DomainValidationException("MinValidator-01", paramName);
        }
    }
}
