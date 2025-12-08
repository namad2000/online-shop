package ir.shop.online.commons.domain.validation;

import java.lang.annotation.*;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/7/2025 8:20 PM
 * Package: ir.shop.online.commons.domain
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsValid {
}
