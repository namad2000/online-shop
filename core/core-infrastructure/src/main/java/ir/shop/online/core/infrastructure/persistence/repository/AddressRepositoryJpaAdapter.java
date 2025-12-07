package ir.shop.online.core.infrastructure.persistence.repository;

import ir.shop.online.core.domain.model.address.Address;
import ir.shop.online.core.domain.model.User;
import ir.shop.online.core.domain.repository.AddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepositoryJpaAdapter implements AddressRepository {

    @PersistenceContext
    private EntityManager em;

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
