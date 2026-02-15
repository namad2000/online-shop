package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.OrderHead;
import ir.online.shop.infrastructure.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface OrderMapper extends CommonsInfrastructureMapper<OrderHead, OrderEntity> {

    OrderHead toDomain(OrderEntity productEntity);

    OrderEntity toEntity(OrderHead product);
}
