package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderCmd;
import ir.online.shop.application.port.in.model.result.order.OrderResult;
import ir.online.shop.domain.model.OrderHead;

@DomainMapper
public class OrderMapper implements InputMapper<CreateOrderCmd, OrderHead>, ResultMapper<OrderHead, OrderResult> {

    @Override
    public OrderHead toDomain(CreateOrderCmd cmd, MappingContext context) {
        return OrderHead.builder()
                .address(cmd.getAddress())
                .postalCode(cmd.getPostalCode())
                .mobile(cmd.getMobile())
//                .product(cmd.getProductId() == null ? null : Product.builder().id(cmd.getProductId()).build())
//                .vendor(cmd.getVendorId() == null ? null : Vendor.builder().id(cmd.getVendorId()).build())
//                .price(BigDecimal.valueOf(cmd.getPrice()))
//                .stockQuantity(cmd.getStockQuantity())
                .build();
    }

    @Override
    public OrderResult toResult(OrderHead order, MappingContext context) {
        OrderItemMapper orderItemMapper = new OrderItemMapper();
        return OrderResult.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .totalItems(order.getTotalItems())
                .totalPrice(order.getTotalPrice())
//                .productId(order.getProduct().getId())
//                .productName(order.getProduct().getName())
//                .thumbnailImageUrl(order.getProduct().getMainThumbnailImage().getUrl())
//                .vendorCommerceName(order.getVendor().getCommercialName())
//                .price(order.getPrice())
//                .stockQuantity(order.getStockQuantity())
                .build();
    }
}
