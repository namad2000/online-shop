package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.OrderItem;
import ir.online.shop.infrastructure.persistence.entity.OrderItemEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface OrderItemMapper extends CommonsInfrastructureMapper<OrderItem, OrderItemEntity> {

    OrderItem toDomain(OrderItemEntity orderItemEntity);

    OrderItemEntity toEntity(OrderItem orderItem);
}
