package ir.shop.online.commons.validation;

import ir.shop.online.commons.domain.annotation.validation.IsValid;
import ir.shop.online.commons.domain.annotation.validation.ValidatedBy;
import ir.shop.online.commons.domain.annotation.validation.validator.AnnotationValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class Validator {

    // Validate the fields of an object
    @SuppressWarnings("unchecked")
    public static <T> void validate(T object) {
        if (object == null) return;

        Class<?> clazz = object.getClass();
        if (isPrimitiveOrWrapper(clazz) || clazz == String.class) return;

        // Iterate over all fields in the class
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                String fieldName = field.getName();  // Get the field name

                // Check annotations on the field
                for (Annotation ann : field.getAnnotations()) {
                    ValidatedBy vb = ann.annotationType().getAnnotation(ValidatedBy.class);
                    if (vb != null) {
                        AnnotationValidator validator = vb.value().getDeclaredConstructor().newInstance();
                        // Pass the field name to the validator
                        validator.validate(value, ann, fieldName);
                    }
                }

                // Recursively validate if the field is annotated with @IsValid
                if (field.isAnnotationPresent(IsValid.class)) {
                    validate(value);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Validate method parameters
    @SuppressWarnings("unchecked")
    public static <T> void validateMethodParams(Object[] args, Parameter[] params) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            Parameter param = params[i];

            // Check annotations on the parameter
            for (Annotation ann : param.getAnnotations()) {
                ValidatedBy vb = ann.annotationType().getAnnotation(ValidatedBy.class);
                if (vb != null) {
                    try {
                        AnnotationValidator validator = vb.value().getDeclaredConstructor().newInstance();
                        // Pass the parameter name to the validator
                        String paramName = param.getName();
                        validator.validate(arg, ann, paramName);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // Recursively validate if the parameter is annotated with @IsValid
            if (param.isAnnotationPresent(IsValid.class)) {
                validate(arg);
            }
        }
    }

    // Helper method to check if a class is a primitive or wrapper
    private static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive()
                || clazz == Byte.class
                || clazz == Short.class
                || clazz == Integer.class
                || clazz == Long.class
                || clazz == Float.class
                || clazz == Double.class
                || clazz == Boolean.class
                || clazz == Character.class;
    }
}

