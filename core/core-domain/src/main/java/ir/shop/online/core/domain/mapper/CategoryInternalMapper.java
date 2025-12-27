package ir.shop.online.core.domain.mapper;

import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.result.category.CategoryResult;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoryInternalMapper {

    public CategoryResult toResult(Category category){
        return CategoryResult.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .build();
    }
}
