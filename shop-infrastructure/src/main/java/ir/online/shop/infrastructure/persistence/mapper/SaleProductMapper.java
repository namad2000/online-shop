package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.infrastructure.persistence.entity.SaleProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface SaleProductMapper extends CommonsInfrastructureMapper<SaleProduct, SaleProductEntity> {

    SaleProduct toDomain(SaleProductEntity saleProductEntity);

    SaleProductEntity toEntity(SaleProduct saleProduct);

}
