package ir.online.shop.infrastructure.persistence.repository.jpa;


import ir.online.shop.domain.model.Customer;
import ir.online.shop.domain.repository.jpa.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    @Override
    public Optional<Customer> findByMobileNumber(String mobileNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public Optional<Customer> findByIdWithAddresses(UUID userId) {
        return Optional.empty();
    }
}
