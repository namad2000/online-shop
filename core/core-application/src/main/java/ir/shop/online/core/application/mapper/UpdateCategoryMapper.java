package ir.shop.online.core.application.mapper;

import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.util.mapper.InputMapper;
import ir.shop.online.commons.util.mapper.MappingContext;
import ir.shop.online.core.application.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.domain.model.Category;

@DomainMapper
public class UpdateCategoryMapper implements InputMapper<UpdateCategoryCmd, Category> {

    @Override
    public Category toDomain(UpdateCategoryCmd cmd, MappingContext context) {
        return Category.builder()
                .id(cmd.getId())
                .title(cmd.getTitle())
                .description(cmd.getDescription())
                .parent(Category.builder().id(cmd.getParentId()).build())
                .version(cmd.getVersion())
                .build();
    }
}
