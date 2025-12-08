package ir.shop.online.commons.validation.aspect;

import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.NotEmpty;
import org.springframework.stereotype.Service;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Service
public class TestValidationService {

    // Valid case
    @IsValid
    public void saveUser(@IsValid TestUser user) {
        // If validation fails, method must NOT reach here
        System.out.println("Method executed successfully");
    }

    // Invalid case
    @IsValid
    public void saveInvalidUser(@IsValid TestUser user) {
        System.out.println("This should NOT execute");
    }

    @IsValid
    public void dummyMethod(@NotEmpty String param) {
        System.out.println("This should NOT execute");
    }
}
