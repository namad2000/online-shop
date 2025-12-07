package ir.shop.online.commons.validation;

import ir.shop.online.commons.domain.annotation.validation.ValidateMethod;
import ir.shop.online.commons.domain.annotation.validation.ValidateParam;
import ir.shop.online.commons.domain.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/7/2025 8:21 PM
 * Package: ir.shop.online.commons.validation
 */

@Aspect
@Component
public class TypeSafeValidationAspect {

    private final TypeSafeValidator typeSafeValidator;

    public TypeSafeValidationAspect(TypeSafeValidator typeSafeValidator) {
        this.typeSafeValidator = typeSafeValidator;
    }

    @Before("@annotation(validateMethod)")
    public void validateMethod(JoinPoint joinPoint, ValidateMethod validateMethod) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg != null) {
                Set<ConstraintViolation<Object>> violations =
                        typeSafeValidator.validate(arg);

                handleViolations(violations);
            }
        }
    }

    @Before("@annotation(validateParam)")
    public void validateParameter(JoinPoint joinPoint, ValidateParam validateParam) {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];

            Set<ConstraintViolation<Object>> violations =
                    typeSafeValidator.validateParameter(
                            parameter.getParameterizedType(),
                            parameter.getName(),
                            args[i]
                    );

            handleViolations(violations, parameter.getName());
        }
    }

    private void handleViolations(Set<ConstraintViolation<Object>> violations) {
        if (!violations.isEmpty()) {
            ConstraintViolation<Object> violation = violations.iterator().next();
            throw new ValidationException(
                    "Validation-01",
                    violation.getMessage()
            );
        }
    }

    private void handleViolations(Set<ConstraintViolation<Object>> violations, String parameterName) {
        if (!violations.isEmpty()) {
            ConstraintViolation<Object> violation = violations.iterator().next();
            throw new ValidationException(
                    "Validation-02",
                    violation.getMessage()
            );
        }
    }
}
