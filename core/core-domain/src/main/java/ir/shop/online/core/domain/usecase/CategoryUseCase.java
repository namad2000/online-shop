package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.category.Category;

public interface CategoryUseCase {

    Category getById(Integer userId);
}
