package ir.shop.online.commons.validation.aspect;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.NotEmpty;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@UseCaseService
public class TestValidationService {

    // Valid case
    public void saveUser(@IsValid TestUser user) {
        // If validation fails, method must NOT reach here
        System.out.println("Method executed successfully");
    }

    // Invalid case
    public void saveInvalidUser(@IsValid TestUser user) {
        System.out.println("This should NOT execute");
    }

    public void dummyMethod(@NotEmpty String param) {
        System.out.println("This should NOT execute");
    }
}
