package ir.shop.online.core.application.adapter;

import ir.shop.online.Infrastructure.repository.UserRepository;
import ir.shop.online.application.dto.req.CreateUserRequest;
import ir.shop.online.application.service.RoleService;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.model.user.User;
import ir.shop.online.core.domain.usecase.UserUseCase;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Role;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@UseCaseService
@RequiredArgsConstructor
public class UserServiceAdapter implements UserUseCase {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public User signup(CreateUserRequest request) {

        // 1) نقش را پیدا کنیم
        Role role = roleService.getByName(request.getRole());

        // 2) بررسی کاربر بر اساس موبایل
        User user = userRepository.findByMobileNumber(request.getMobile())
                .orElse(null);

        // 3) اگر کاربر قبلاً ثبت شده
        if (user != null) {

            // آیا این نقش را دارد؟
            boolean roleExists = user.getRoles()
                    .stream()
                    .anyMatch(r -> r.getName().equals(role.getName()));

            if (roleExists) {
                throw new DomainException(ExceptionCode.USER_01); // این نقش قبلاً برای کاربر ثبت شده
            }

            // نقش جدید را اضافه کنیم
            user.getRoles().add(role);

            return userRepository.save(user);
        }

        // 4) اگر کاربر جدید است
        User newUser = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .mobileNumber(request.getMobile())
                .roles(new HashSet<>(Set.of(role)))
                .build();

        return userRepository.save(newUser);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DomainException(ExceptionCode.USER_02));
    }
}
