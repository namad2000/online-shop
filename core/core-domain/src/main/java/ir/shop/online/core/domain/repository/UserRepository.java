package ir.shop.online.core.domain.repository;


import ir.shop.online.core.domain.model.User;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findByMobileNumber(String mobileNumber);

    Optional<User> findByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);

    Optional<User> findByIdWithAddresses(Long userId);
}
