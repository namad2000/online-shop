package ir.shop.online.commons.util.mapper;

import lombok.Getter;

@Getter
class UserEntity {
    private Long id;
    private String name;

    // constructor
    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
