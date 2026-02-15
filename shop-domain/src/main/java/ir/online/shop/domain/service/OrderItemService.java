package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.exception.OrderExceptionCode;
import ir.online.shop.domain.model.OrderHead;
import ir.online.shop.domain.model.OrderItem;
import ir.online.shop.domain.repository.jpa.OrderItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> create(OrderHead orderHead, List<OrderItem> items) {
        for (OrderItem item : items) {
            item.setOrderHead(orderHead);
        }
        return orderItemRepository.saveAll(items);
    }

    public OrderItem getById(UUID orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> DomainException.of(OrderExceptionCode.ORDER_NOT_FOUND));
    }
}
