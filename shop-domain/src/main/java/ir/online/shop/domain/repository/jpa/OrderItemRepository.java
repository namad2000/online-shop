package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.OrderItem;

import java.util.List;
import java.util.UUID;


public interface OrderItemRepository extends DomainRepository<OrderItem, UUID> {
    List<OrderItem> saveAll(List<OrderItem> items);
}
