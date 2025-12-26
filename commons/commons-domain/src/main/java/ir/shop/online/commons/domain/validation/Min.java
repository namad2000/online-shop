package ir.shop.online.commons.domain.validation;

import ir.shop.online.commons.domain.validation.validator.MinValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@ValidatedBy(MinValidator.class)
public @interface Min {
    long value();
}
