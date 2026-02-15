package ir.online.shop.presentation.rest.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderCmd;
import ir.online.shop.application.port.in.model.result.order.OrderResult;
import ir.online.shop.presentation.rest.dto.req.order.CreateOrderRequest;
import ir.online.shop.presentation.rest.dto.res.order.OrderResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonsMapperConfig.class)
public interface OrderCommandMapper {

    CreateOrderCmd toCommand(CreateOrderRequest request);

    OrderResponse toResponse(OrderResult result);
    List<OrderResponse> toResponse(List<OrderResult> result);

}
