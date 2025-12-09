package ir.shop.online.commons.property;

import ir.shop.online.commons.domain.property.Property;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class PropertyInjector implements BeanPostProcessor {

    private final Environment environment;

    public PropertyInjector(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Property.class)) {
                Property annotation = field.getAnnotation(Property.class);
                String value = environment.getProperty(annotation.key(), annotation.defaultValue());
                boolean accessible = field.canAccess(bean);
                field.setAccessible(true);
                try {
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(accessible);
            }
        }
        return bean;
    }
}
