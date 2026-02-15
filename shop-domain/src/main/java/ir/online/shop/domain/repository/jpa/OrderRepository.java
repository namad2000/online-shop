package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.OrderHead;

import java.util.UUID;


public interface OrderRepository extends DomainRepository<OrderHead, UUID> {
}
