package ir.shop.online.infrastructure.mapper;

import ir.shop.online.application.dto.CategoryDTO;
import ir.shop.online.domain.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "parent", target = "parentId", qualifiedByName = "parentId")
    @Mapping(source = "parent", target = "parentTitle", qualifiedByName = "parentTitle")
    CategoryDTO toDTO(Category category);

    @Named("parentId")
    default Long mapParentId(Category parent) {
        return parent != null ? parent.getId() : null;
    }

    @Named("parentTitle")
    default String mapParentTitle(Category parent) {
        return parent != null ? parent.getTitle() : null;
    }
}
