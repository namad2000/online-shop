package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainService;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.domain.model.Category;

@DomainService
public class CategoryMapper implements InputMapper<CreateCategoryCmd, Category>, ResultMapper<Category, CategoryResult> {

    @Override
    public Category toDomain(CreateCategoryCmd cmd, MappingContext context) {
        return Category.builder()
                .name(cmd.getName())
                .description(cmd.getDescription())
                .parent(cmd.getParentId() == null ? null : Category.builder().id(cmd.getParentId()).build())
                .build();
    }

    @Override
    public CategoryResult toResult(Category domain, MappingContext context) {
        return CategoryResult.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
//                .parent(domain.getParent() != null ? CategoryResult.builder()
//                        .id(domain.getParent().getId())
//                        .name(domain.getParent().getName())
//                        .description(domain.getParent().getDescription())
//                        .build() : null)
                .build();
    }
}
