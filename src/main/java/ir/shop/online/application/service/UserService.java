package ir.shop.online.application.service;

import ir.shop.online.application.dto.req.CreateUserRequest;
import ir.shop.online.domain.model.entity.User;

public interface UserService {
    User signup(CreateUserRequest request);
}
