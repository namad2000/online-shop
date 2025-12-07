package ir.shop.online.commons.validation;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Set;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/7/2025 8:52 PM
 * Package: ir.shop.online.commons.validation
 */


@Component
public class TypeSafeValidator {

    private final jakarta.validation.Validator validator;

    public TypeSafeValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * Type-safe validation برای مقادیر
     */
    public <T> Set<ConstraintViolation<T>> validateValue(
            Class<T> beanType,
            String propertyName,
            Object value) {

        return validator.validateValue(beanType, propertyName, value);
    }

    /**
     * Validation برای اشیاء
     */
    public <T> Set<ConstraintViolation<T>> validate(T object) {
        return validator.validate(object);
    }

    /**
     * Validation برای پارامترهای متد با استفاده از reflection
     */
    @SuppressWarnings("unchecked")
    public Set<ConstraintViolation<Object>> validateParameter(
            Type parameterType,
            String parameterName,
            Object value) {

        if (parameterType instanceof Class<?> clazz) {
            return validator.validateValue((Class<Object>) clazz, parameterName, value);
        }

        return Collections.emptySet();
    }
}