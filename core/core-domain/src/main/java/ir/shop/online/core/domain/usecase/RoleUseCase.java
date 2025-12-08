package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.role.Role;

public interface RoleUseCase {
    Role getByName(String name);
}
