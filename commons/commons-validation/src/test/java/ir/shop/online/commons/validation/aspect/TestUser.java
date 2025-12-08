package ir.shop.online.commons.validation.aspect;

import ir.shop.online.commons.domain.annotation.validation.IsValid;
import ir.shop.online.commons.domain.annotation.validation.NotEmpty;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

public class TestUser {

    @NotEmpty
    private String name;

    @IsValid
    private NestedInfo nested;

    public TestUser(String name, NestedInfo nested) {
        this.name = name;
        this.nested = nested;
    }
}