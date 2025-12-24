package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.CreateCategory;
import ir.shop.online.core.domain.model.category.UpdateCategory;

public interface CategoryUseCase {
    Category create(CreateCategory createCategory);

    Category update(Integer id, UpdateCategory createCategory);

    Category getById(Integer userId);
}
