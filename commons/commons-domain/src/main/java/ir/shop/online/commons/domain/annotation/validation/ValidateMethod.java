package ir.shop.online.commons.domain.annotation.validation;

import java.lang.annotation.*;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/7/2025 8:20 PM
 * Package: ir.shop.online.commons.domain
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateMethod {
}