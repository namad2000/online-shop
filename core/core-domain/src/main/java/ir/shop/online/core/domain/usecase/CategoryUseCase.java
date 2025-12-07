package ir.shop.online.core.domain.usecase;

import ir.shop.online.application.dto.req.CreateCategoryRequest;
import ir.shop.online.application.dto.req.CreateUserRequest;
import ir.shop.online.domain.model.entity.Category;
import ir.shop.online.domain.model.entity.User;

public interface CategoryUseCase {
    Category create(CreateCategoryRequest request);

    Category getById(Integer userId);
}
