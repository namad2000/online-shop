package ir.shop.online.commons.validation.validator;

import ir.shop.online.commons.domain.annotation.validation.IsValid;
import ir.shop.online.commons.domain.annotation.validation.NotEmpty;

public class UserTestModel {

    @NotEmpty
    private String username;

    @IsValid
    private NestedInfo nested;

    public UserTestModel(String username, NestedInfo nested) {
        this.username = username;
        this.nested = nested;
    }
}