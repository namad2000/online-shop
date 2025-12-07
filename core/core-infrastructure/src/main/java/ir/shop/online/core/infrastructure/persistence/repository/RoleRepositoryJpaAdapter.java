package ir.shop.online.core.infrastructure.persistence.repository;


import ir.shop.online.core.domain.model.Role;
import ir.shop.online.core.domain.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryJpaAdapter implements RoleRepository {

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }
}
