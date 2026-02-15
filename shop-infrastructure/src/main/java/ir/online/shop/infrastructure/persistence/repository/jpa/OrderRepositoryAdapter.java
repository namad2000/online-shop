package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.OrderHead;
import ir.online.shop.domain.repository.jpa.OrderRepository;
import ir.online.shop.infrastructure.persistence.entity.OrderEntity;
import ir.online.shop.infrastructure.persistence.mapper.OrderMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderHead save(OrderHead order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        orderEntity = orderJpaRepository.save(orderEntity);

        return orderMapper.toDomain(orderEntity);
    }

    @Override
    public Optional<OrderHead> findById(UUID id) {
        return orderJpaRepository.findById(id)
                .map(orderMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return orderJpaRepository.existsById(id);
    }

    @Override
    public PageData<OrderHead> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(OrderHead domain, boolean logical) {

    }
}
