package ir.shop.online.commons.domain.validation;

import ir.shop.online.commons.domain.validation.validator.NotEmptyValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@ValidatedBy(NotEmptyValidator.class)
public @interface NotEmpty {
}
