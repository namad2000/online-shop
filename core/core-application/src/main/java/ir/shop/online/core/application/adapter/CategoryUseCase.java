package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.NotNull;
import ir.shop.online.core.application.mapper.CategoryMapper;
import ir.shop.online.core.application.mapper.UpdateCategoryMapper;
import ir.shop.online.core.application.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.application.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.application.model.result.category.CategoryResult;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class CategoryUseCase {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final UpdateCategoryMapper updateCategoryMapper;


    public CategoryResult create(@IsValid CreateCategoryCmd createCategoryCmd) {
        Category newCategory = categoryMapper.toDomain(createCategoryCmd);
        Category save = categoryService.create(newCategory);
        return categoryMapper.toResult(save);
    }

    public CategoryResult update(@IsValid UpdateCategoryCmd command) {

        Category category = updateCategoryMapper.toDomain(command);

        return categoryMapper.toResult(categoryService.update(category));
    }

    @IsValid
    public CategoryResult getById(@NotNull Integer categoryId) {
        return categoryMapper.toResult(categoryService.getById(categoryId));
    }
}
