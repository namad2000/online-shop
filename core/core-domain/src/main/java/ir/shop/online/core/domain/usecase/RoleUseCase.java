package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.Role;

public interface RoleUseCase {
    Role getByName(String name);
}
