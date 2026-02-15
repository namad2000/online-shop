package ir.online.shop.domain.repository.jpa;


import ir.online.shop.domain.model.Address;
import ir.online.shop.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    List<Address> findByUserId(Long userId);

    Optional<Address> findByUserIdAndIsDefaultTrue(Long userId);

    Address findByUserAndTitle(Customer customer, String title);

    long countByUserId(Long userId);
}
