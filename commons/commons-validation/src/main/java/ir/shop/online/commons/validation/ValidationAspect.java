package ir.shop.online.commons.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Aspect
@Component
public class ValidationAspect {

    // Before advice that runs before method execution with @IsValid annotations
    @Before("execution(* *(..)) && @annotation(ir.shop.online.commons.domain.annotation.validation.IsValid)")
    // Apply only on methods with @IsValid annotation
    public void validateMethod(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // Validate method parameters
        Object[] args = joinPoint.getArgs();
        Parameter[] params = method.getParameters();
        Validator.validateMethodParams(args, params);

        // Validate any field in the method parameters with @IsValid annotation (nested objects)
        for (Object arg : args) {
            if (arg != null) {
                Validator.validate(arg);
            }
        }
    }

    // Aspect for validating fields annotated with @IsValid
    @Before("execution(* *(..)) && @annotation(ir.shop.online.commons.domain.annotation.validation.IsValid)")
    // Apply before any method execution with @IsValid
    public void validateFields(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        // Iterate through method parameters and validate the fields of each parameter if they are annotated with @IsValid
        for (Object arg : args) {
            if (arg != null) {
                Validator.validate(arg);  // Validate nested fields recursively
            }
        }
    }
}

