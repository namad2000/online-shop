package ir.online.shop.infrastructure.persistence.repository.jpa;//package ir.online.shop.infrastructure.persistence.repository.jpa;
//
//import ir.shop.online.commons.infrastructure.repository.JpaRepository;
//import ir.online.shop.domain.model.address.Address;
//import ir.online.shop.domain.model.user.Customer;
//import ir.online.shop.domain.repository.jpa.AddressRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class AddressRepositoryJpaAdapter extends JpaRepository<Address, Long> implements AddressRepository {
//
//    @Override
//    public List<Address> findByUserId(Long userId) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Address> findByUserIdAndIsDefaultTrue(Long userId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Address findByUserAndTitle(Customer user, String title) {
//        return null;
//    }
//
//    @Override
//    public long countByUserId(Long userId) {
//        return 0;
//    }
//}
