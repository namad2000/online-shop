package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.cmd.CreateCategoryCmd;
import ir.shop.online.core.domain.model.category.cmd.UpdateCategoryCmd;

public interface CategoryUseCase {
    Category create(CreateCategoryCmd createCategoryCmd);

    Category update(Integer id, UpdateCategoryCmd createCategory);

    Category getById(Integer userId);
}
