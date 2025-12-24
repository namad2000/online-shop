//package ir.shop.online.core.infrastructure.persistence.repository.jpa;
//
//
//import ir.shop.online.core.domain.model.user.User;
//import ir.shop.online.core.domain.repository.jpa.UserRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserRepositoryAdapter implements UserRepository {
//
//    @Override
//    public Optional<User> findByMobileNumber(String mobileNumber) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsByMobileNumber(String mobileNumber) {
//        return false;
//    }
//
//    @Override
//    public boolean existsByEmail(String email) {
//        return false;
//    }
//
//    @Override
//    public Optional<User> findByIdWithAddresses(Long userId) {
//        return Optional.empty();
//    }
//}
