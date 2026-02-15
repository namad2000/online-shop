package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderItemCmd;
import ir.online.shop.application.port.in.model.result.order.OrderItemResult;
import ir.online.shop.domain.model.OrderItem;

@DomainMapper
public class OrderItemMapper implements InputMapper<CreateOrderItemCmd, OrderItem>, ResultMapper<OrderItem, OrderItemResult> {

    @Override
    public OrderItem toDomain(CreateOrderItemCmd cmd, MappingContext context) {
        return OrderItem.builder()
                .quantity(cmd.getQuantity())
                .build();
    }

    @Override
    public OrderItemResult toResult(OrderItem order, MappingContext context) {
        return OrderItemResult.builder()
                .id(order.getId())
                .saleProductId(order.getSaleProduct().getId())
                .productName(order.getSaleProduct().getProduct().getName())
                .quantity(order.getQuantity())
                .pricePerUnit(order.getPricePerUnit())
//                .productId(order.getProduct().getId())
//                .productName(order.getProduct().getName())
//                .thumbnailImageUrl(order.getProduct().getMainThumbnailImage().getUrl())
//                .vendorCommerceName(order.getVendor().getCommercialName())
//                .price(order.getPrice())
//                .stockQuantity(order.getStockQuantity())
                .build();
    }
}
