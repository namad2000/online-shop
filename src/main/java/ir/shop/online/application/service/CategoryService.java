package ir.shop.online.application.service;

import ir.shop.online.application.dto.req.CreateCategoryRequest;
import ir.shop.online.application.dto.req.CreateUserRequest;
import ir.shop.online.domain.model.entity.Category;
import ir.shop.online.domain.model.entity.User;

public interface CategoryService {
    Category create(CreateCategoryRequest request);

    Category getById(Integer userId);
}
