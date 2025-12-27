package ir.shop.online.core.application.mapper;

import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.util.mapper.Mapper;
import ir.shop.online.commons.util.mapper.MappingContext;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.result.category.CategoryResult;

@DomainMapper
public class CategoryInternalMapper implements Mapper<Category, CategoryResult> {
    @Override
    public CategoryResult map(Category category, MappingContext context) {
        return CategoryResult.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .build();
    }
}
