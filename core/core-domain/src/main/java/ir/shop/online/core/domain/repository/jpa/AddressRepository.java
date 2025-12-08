package ir.shop.online.core.domain.repository.jpa;

import ir.shop.online.core.domain.model.address.Address;
import ir.shop.online.core.domain.model.user.User;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    List<Address> findByUserId(Long userId);

    Optional<Address> findByUserIdAndIsDefaultTrue(Long userId);

    Address findByUserAndTitle(User user, String title);

    long countByUserId(Long userId);
}
