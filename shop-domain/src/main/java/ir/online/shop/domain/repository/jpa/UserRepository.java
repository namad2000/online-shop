package ir.online.shop.domain.repository.jpa;

import ir.online.shop.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository {

    Optional<Customer> findByMobileNumber(String mobileNumber);

    Optional<Customer> findByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);

    Optional<Customer> findByIdWithAddresses(UUID userId);
}
