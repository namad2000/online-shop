package ir.shop.online.core.domain.usecase;

import ir.shop.online.domain.model.entity.Role;

public interface RoleUseCase {
    Role getByName(String name);
}
