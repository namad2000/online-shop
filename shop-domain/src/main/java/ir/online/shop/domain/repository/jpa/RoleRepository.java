package ir.online.shop.domain.repository.jpa;

import ir.online.shop.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(String name);
}
