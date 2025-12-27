package ir.shop.online.core.domain.usecase;


import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.domain.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.domain.model.result.category.CategoryResult;

public interface CategoryUseCase {
    CategoryResult create(CreateCategoryCmd createCategoryCmd);

    Category update(Integer id, UpdateCategoryCmd createCategory);

    Category getById(Integer userId);
}
