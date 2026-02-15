package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.Product;
import ir.online.shop.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface ProductMapper extends CommonsInfrastructureMapper<Product, ProductEntity> {

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

}
