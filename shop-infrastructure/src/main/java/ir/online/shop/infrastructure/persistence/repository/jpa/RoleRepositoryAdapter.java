package ir.online.shop.infrastructure.persistence.repository.jpa;


import ir.online.shop.domain.model.Role;
import ir.online.shop.domain.repository.jpa.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryAdapter implements RoleRepository {

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }
}
