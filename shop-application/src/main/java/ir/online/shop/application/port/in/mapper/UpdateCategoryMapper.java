package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
import ir.online.shop.domain.model.Category;

@DomainMapper
public class UpdateCategoryMapper implements InputMapper<UpdateCategoryCmd, Category> {

    @Override
    public Category toDomain(UpdateCategoryCmd cmd, MappingContext context) {
        return Category.builder()
                .id(cmd.getId())
                .name(cmd.getName())
                .description(cmd.getDescription())
                .parent(Category.builder().id(cmd.getParentId()).build())
                .version(cmd.getVersion())
                .build();
    }
}
