package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.address.CreateUser;
import ir.shop.online.core.domain.model.user.User;

public interface UserUseCase {
    User signup(CreateUser request);

    User getById(Long userId);
}
