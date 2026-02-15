package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.infrastructure.persistence.entity.OrderEntity;
import ir.online.shop.infrastructure.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, UUID> {
}
