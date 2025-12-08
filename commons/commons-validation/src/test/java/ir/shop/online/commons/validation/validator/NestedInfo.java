package ir.shop.online.commons.validation.validator;

import ir.shop.online.commons.domain.validation.NotEmpty;

public class NestedInfo {
    @NotEmpty
    private String title;

    public NestedInfo(String title) {
        this.title = title;
    }
}