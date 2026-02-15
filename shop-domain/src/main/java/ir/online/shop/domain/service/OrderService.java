package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.exception.OrderExceptionCode;
import ir.online.shop.domain.model.Customer;
import ir.online.shop.domain.model.OrderHead;
import ir.online.shop.domain.model.enums.OrderStatus;
import ir.online.shop.domain.repository.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderHead create(OrderHead newOrder/*, List<OrderItem> items*/, Customer customer) {
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setOrderStatus(OrderStatus.INITIAL_REGISTER);
        newOrder.setCustomer(customer);
//        newOrder.setItems(items);
        return orderRepository.save(newOrder);
    }

    public OrderHead getById(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> DomainException.of(OrderExceptionCode.ORDER_NOT_FOUND));
    }

    public void update(OrderHead order) {
        orderRepository.save(order);
    }
}
