package ir.online.shop.presentation.rest;

import ir.online.shop.application.port.in.model.cmd.order.CreateOrderCmd;
import ir.online.shop.application.port.in.model.result.order.OrderResult;
import ir.online.shop.application.port.in.usecase.OrderUseCase;
import ir.online.shop.presentation.rest.dto.req.order.CreateOrderRequest;
import ir.online.shop.presentation.rest.dto.res.order.OrderResponse;
import ir.online.shop.presentation.rest.mapper.OrderCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderUseCase orderUseCase;
    private final OrderCommandMapper orderCommandMapper;

    @PostMapping("/create")
    public OrderResponse create(
            @RequestBody CreateOrderRequest request) {
        CreateOrderCmd command = orderCommandMapper.toCommand(request);
        OrderResult orderResult = orderUseCase.create(command);
        return orderCommandMapper.toResponse(orderResult);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrder(
            @PathVariable UUID orderId) {
        return orderCommandMapper.toResponse(orderUseCase.getByIdActiveAndNotDeleted(orderId));
    }

    @GetMapping("/search")
    public List<OrderResponse> getOrder(
            @RequestParam("name") String name,
            @RequestParam("minPrice") Long minPrice,
            @RequestParam("maxPrice") Long maxPrice,
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize
    ) {
        return orderCommandMapper.toResponse(orderUseCase.search(
                name,
                minPrice,
                maxPrice,
                pageNumber,
                pageSize
        ));
    }

}
