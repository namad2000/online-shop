package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.Category;
import ir.online.shop.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CommonsMapperConfig.class)
public interface CategoryMapper extends CommonsInfrastructureMapper<Category, CategoryEntity> {

    /* =================================================
     * Base mapping (USED FOR PARENT MAPPING)
     * ================================================= */
    @Named("base")
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    Category toDomain(CategoryEntity entity);

    /* =================================================
     * Category + Parent
     * ================================================= */
    @Mapping(target = "parent", qualifiedByName = "base")
    @Mapping(target = "children", ignore = true)
    Category toDomainWithParent(CategoryEntity entity);

    /* =================================================
     * Category + Children
     * ================================================= */
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", qualifiedByName = "base")
    Category toDomainWithChildren(CategoryEntity entity);

    /* =================================================
     * Category + Parent + Children
     * ================================================= */
    @Mapping(target = "parent", qualifiedByName = "base")
    @Mapping(target = "children", qualifiedByName = "base")
    Category toDomainWithParentAndChildren(CategoryEntity entity);

    /* =================================================
     * Domain ➜ Entity (category + parent only)
     * ================================================= */
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "parent", qualifiedByName = "parentOnly")
    CategoryEntity toEntity(Category domain);

    /* =================================================
     * Parent helper (ID reference only)
     * ================================================= */
    @Named("parentOnly")
    default CategoryEntity map(Category parent) {
        if (parent == null) return null;

        CategoryEntity entity = new CategoryEntity();
        entity.setId(parent.getId());
        entity.setVersion(parent.getVersion());
        return entity;
    }
}
