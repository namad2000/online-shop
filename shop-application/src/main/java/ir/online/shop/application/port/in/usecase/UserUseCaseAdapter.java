package ir.online.shop.application.port.in.usecase;//package ir.online.core.application.adapter;
//
//
//import ir.online.commons.filter.bean.UseCaseService;
//import ir.online.commons.domain.exception.DomainBusinessException;
//import ir.online.core.domain.model.address.CreateUser;
//import ir.online.core.domain.model.role.Role;
//import ir.online.core.domain.model.customer.Customer;
//import ir.online.core.domain.repository.jpa.UserRepository;
//import ir.online.core.domain.usecase.RoleUseCase;
//import ir.online.core.domain.usecase.UserUseCase;
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
//    public Customer signup(CreateUser request) {
//
//        Role role = roleService.getByName(request.getRole());
//        Customer customer = userRepository.findByMobileNumber(request.getMobile())
//                .orElse(null);
//
//        if (customer != null) {
//            boolean roleExists = customer.getRoles()
//                    .stream()
//                    .anyMatch(r -> r.getName().equals(role.getName()));
//
//            if (roleExists) {
//                throw new DomainBusinessException(USER_01); // این نقش قبلاً برای کاربر ثبت شده
//            }
//
//            // نقش جدید را اضافه کنیم
//            customer.getRoles().add(role);
//
//            return userRepository.save(customer);
//        }
//
//        // 4) اگر کاربر جدید است
//        Customer newUser = Customer.builder()
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
//    public Customer getById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> DomainException.of(ExceptionCode.USER_02));
//    }
//}
