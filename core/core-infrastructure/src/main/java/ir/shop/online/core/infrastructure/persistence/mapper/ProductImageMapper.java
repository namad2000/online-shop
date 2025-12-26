package ir.shop.online.core.infrastructure.persistence.mapper;

import ir.shop.online.commons.infrastructure.persistence.mapper.CommonsInfrastructureMapper;
import ir.shop.online.commons.mapper.CommonsMapperConfig;
import ir.shop.online.core.domain.model.ProductImage;
import ir.shop.online.core.infrastructure.persistence.entity.ProductImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonsMapperConfig.class)
public interface ProductImageMapper extends CommonsInfrastructureMapper<ProductImage, ProductImageEntity> {

    // Entity -> Domain
    @Mapping(target = "product", ignore = true)
    ProductImage toDomain(ProductImageEntity entity);

    // Domain -> Entity
    @Mapping(target = "product", ignore = true)
    ProductImageEntity toEntity(ProductImage domain);

}
