package ir.shop.online.core.infrastructure.persistence.mapper;

import ir.shop.online.commons.infrastructure.persistence.mapper.InfraMapper;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends InfraMapper<Category, CategoryEntity> {

    //    @Mapping(source = "parent", target = "parent", qualifiedByName = "parentId")
//    @Mapping(source = "parent", target = "parentTitle", qualifiedByName = "parentTitle")
    Category toDomain(CategoryEntity categoryEntity);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    CategoryEntity toEntity(Category category);

//    @Named("parentId")
//    default Long mapParentId(CategoryEntity parent) {
//        return parent != null ? parent.getId() : null;
//    }
//
//    @Named("parentTitle")
//    default String mapParentTitle(CategoryEntity parent) {
//        return parent != null ? parent.getTitle() : null;
//    }
}
