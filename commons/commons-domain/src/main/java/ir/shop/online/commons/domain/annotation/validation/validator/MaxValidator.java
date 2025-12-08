package ir.shop.online.commons.domain.annotation.validation.validator;

import ir.shop.online.commons.domain.annotation.validation.Max;
import ir.shop.online.commons.domain.exception.DomainValidationException;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

public class MaxValidator implements AnnotationValidator<Number, Max> {
    @Override
    public void validate(Number value, Max annotation, String paramName) {
        if (value != null && value.longValue() > annotation.value()) {
            throw new DomainValidationException("MaxValidator-01", paramName);
        }
    }
}
