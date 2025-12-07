package ir.shop.online.core.domain.repository;


import ir.shop.online.core.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(String name);

}
