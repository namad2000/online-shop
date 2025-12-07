package ir.shop.online.application.service;

import ir.shop.online.domain.model.entity.Role;

public interface RoleService {
    Role getByName(String name);
}
