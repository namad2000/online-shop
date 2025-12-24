package ir.shop.online.core.infrastructure.persistence.mapper;

import ir.shop.online.commons.infrastructure.persistence.mapper.CommonsInfrastructureMapper;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonsInfrastructureMapper<Category, CategoryEntity> {
     /* =====================
       Entity → Domain
     ===================== */

//    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    Category toDomain(CategoryEntity entity);

//    default Category toDomainTree(CategoryEntity entity) {
//        if (entity == null) return null;
//
//        Category category = toDomain(entity);
//
//        category.setParent(toDomainTree(entity.getParent()));
//
//        if (entity.getChildren() != null) {
//            category.setChildren(
//                    entity.getChildren()
//                            .stream()
//                            .map(this::toDomainTree)
//                            .collect(Collectors.toSet())
//            );
//        }
//
//        return category;
//    }

    /* =====================
       Domain → Entity
     ===================== */

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
//    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    CategoryEntity toEntity(Category domain);

//    default CategoryEntity toEntityTree(Category domain) {
//        if (domain == null) return null;
//
//        CategoryEntity entity = toEntity(domain);
//
//        entity.setParent(toEntityTree(domain.getParent()));
//
//        if (domain.getChildren() != null) {
//            Set<CategoryEntity> children = domain.getChildren()
//                    .stream()
//                    .map(child -> {
//                        CategoryEntity childEntity = toEntityTree(child);
//                        childEntity.setParent(entity);
//                        return childEntity;
//                    })
//                    .collect(Collectors.toSet());
//
//            entity.setChildren(children);
//        }
//
//        return entity;
//    }

//    //    @Mapping(source = "parent", target = "parent", qualifiedByName = "parentId")
////    @Mapping(source = "parent", target = "parentTitle", qualifiedByName = "parentTitle")
//    Category toDomain(CategoryEntity categoryEntity);
//
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "createdBy", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "updatedBy", ignore = true)
//    @Mapping(target = "isActive", ignore = true)
//    @Mapping(target = "isDeleted", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "deletedBy", ignore = true)
//    CategoryEntity toEntity(Category category);
//
////    @Named("parentId")
////    default Long mapParentId(CategoryEntity parent) {
////        return parent != null ? parent.getId() : null;
////    }
////
////    @Named("parentTitle")
////    default String mapParentTitle(CategoryEntity parent) {
////        return parent != null ? parent.getTitle() : null;
////    }
}
