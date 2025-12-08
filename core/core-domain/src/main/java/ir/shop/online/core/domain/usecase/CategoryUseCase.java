package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.CreateCategory;

public interface CategoryUseCase {
    Category create(CreateCategory createCategory);

    Category getById(Integer userId);
}
