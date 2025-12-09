package ir.shop.online.core.infrastructure.persistence.repository.jpa;

import ir.shop.online.commons.infrastructure.repository.JpaRepository;
import ir.shop.online.core.domain.model.address.Address;
import ir.shop.online.core.domain.model.user.User;
import ir.shop.online.core.domain.repository.jpa.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepositoryJpaAdapter extends JpaRepository<Address, Long> implements AddressRepository {

    @Override
    public List<Address> findByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Optional<Address> findByUserIdAndIsDefaultTrue(Long userId) {
        return Optional.empty();
    }

    @Override
    public Address findByUserAndTitle(User user, String title) {
        return null;
    }

    @Override
    public long countByUserId(Long userId) {
        return 0;
    }
}
