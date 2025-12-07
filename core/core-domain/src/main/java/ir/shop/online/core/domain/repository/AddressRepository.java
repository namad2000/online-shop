package ir.shop.online.core.domain.repository;

import ir.shop.online.core.domain.model.address.Address;
import ir.shop.online.core.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    List<Address> findByUserId(Long userId);

    Optional<Address> findByUserIdAndIsDefaultTrue(Long userId);

    Address findByUserAndTitle(User user, String title);

    long countByUserId(Long userId);
}
