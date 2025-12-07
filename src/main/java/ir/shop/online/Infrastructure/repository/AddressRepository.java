package ir.shop.online.Infrastructure.repository;

import ir.shop.online.domain.model.entity.Address;
import ir.shop.online.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

    Optional<Address> findByUserIdAndIsDefaultTrue(Long userId);

    Address findByUserAndTitle(User user, String title);

    long countByUserId(Long userId);
}
