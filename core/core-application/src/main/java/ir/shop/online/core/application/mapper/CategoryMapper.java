package ir.shop.online.core.application.mapper;

import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.util.mapper.InputMapper;
import ir.shop.online.commons.util.mapper.MappingContext;
import ir.shop.online.commons.util.mapper.ResultMapper;
import ir.shop.online.core.application.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.application.model.result.category.CategoryResult;
import ir.shop.online.core.domain.model.Category;

@DomainMapper
public class CategoryMapper implements InputMapper<CreateCategoryCmd, Category>, ResultMapper<Category, CategoryResult> {

    @Override
    public Category toDomain(CreateCategoryCmd cmd, MappingContext context) {
        return Category.builder()
                .title(cmd.getTitle())
                .description(cmd.getDescription())
                .parent(Category.builder().id(cmd.getParentId()).build())
                .build();
    }

    @Override
    public CategoryResult toResult(Category domain, MappingContext context) {
        return CategoryResult.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .build();
    }
}
