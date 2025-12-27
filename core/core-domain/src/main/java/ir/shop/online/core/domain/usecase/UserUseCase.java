package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.User;
import ir.shop.online.core.domain.model.cmd.user.CreateUser;

public interface UserUseCase {
    User signup(CreateUser request);

    User getById(Long userId);
}
