package ir.shop.online.core.infrastructure.persistence.mapper;

import ir.shop.online.commons.infrastructure.persistence.mapper.CommonsInfrastructureMapper;
import ir.shop.online.commons.mapper.CommonsMapperConfig;
import ir.shop.online.core.domain.model.product.Product;
import ir.shop.online.core.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonsMapperConfig.class)
public interface ProductMapper extends CommonsInfrastructureMapper<Product, ProductEntity> {

    Product toDomain(ProductEntity productEntity);

    @Mapping(target = "images", ignore = true) // managed by ProductImageMapper
    ProductEntity toEntity(Product product);

}
