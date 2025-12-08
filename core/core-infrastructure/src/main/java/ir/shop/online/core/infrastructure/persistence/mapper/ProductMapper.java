package ir.shop.online.core.infrastructure.persistence.mapper;

import ir.shop.online.core.domain.model.product.Product;
import ir.shop.online.core.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity productEntity);
}
