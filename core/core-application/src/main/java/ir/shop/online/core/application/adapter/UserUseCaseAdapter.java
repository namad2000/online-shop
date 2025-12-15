//package ir.shop.online.core.application.adapter;
//
//
//import ir.shop.online.commons.domain.annotation.UseCaseService;
//import ir.shop.online.commons.domain.exception.DomainBusinessException;
//import ir.shop.online.core.domain.model.address.CreateUser;
//import ir.shop.online.core.domain.model.role.Role;
//import ir.shop.online.core.domain.model.user.User;
//import ir.shop.online.core.domain.repository.jpa.UserRepository;
//import ir.shop.online.core.domain.usecase.RoleUseCase;
//import ir.shop.online.core.domain.usecase.UserUseCase;
//import lombok.RequiredArgsConstructor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@UseCaseService
//@RequiredArgsConstructor
//public class UserUseCaseAdapter implements UserUseCase {
//
//    private final UserRepository userRepository;
//    private final RoleUseCase roleService;
//
//    @Override
//    public User signup(CreateUser request) {
//
//        Role role = roleService.getByName(request.getRole());
//        User user = userRepository.findByMobileNumber(request.getMobile())
//                .orElse(null);
//
//        if (user != null) {
//            boolean roleExists = user.getRoles()
//                    .stream()
//                    .anyMatch(r -> r.getName().equals(role.getName()));
//
//            if (roleExists) {
//                throw new DomainBusinessException(USER_01); // این نقش قبلاً برای کاربر ثبت شده
//            }
//
//            // نقش جدید را اضافه کنیم
//            user.getRoles().add(role);
//
//            return userRepository.save(user);
//        }
//
//        // 4) اگر کاربر جدید است
//        User newUser = User.builder()
//                .firstName(request.getFirstname())
//                .lastName(request.getLastname())
//                .email(request.getEmail())
//                .mobileNumber(request.getMobile())
//                .roles(new HashSet<>(Set.of(role)))
//                .build();
//
//        return userRepository.save(newUser);
//    }
//
//    @Override
//    public User getById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new DomainException(ExceptionCode.USER_02));
//    }
//}
