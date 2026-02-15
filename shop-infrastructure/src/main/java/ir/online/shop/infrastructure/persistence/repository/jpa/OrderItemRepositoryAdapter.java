package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.OrderItem;
import ir.online.shop.domain.repository.jpa.OrderItemRepository;
import ir.online.shop.infrastructure.persistence.entity.OrderItemEntity;
import ir.online.shop.infrastructure.persistence.mapper.OrderItemMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.OrderItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryAdapter implements OrderItemRepository {

    private final OrderItemJpaRepository orderItemJpaRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItem save(OrderItem orderItem) {
        OrderItemEntity orderItemEntity = orderItemMapper.toEntity(orderItem);
        orderItemEntity = orderItemJpaRepository.save(orderItemEntity);

        return orderItemMapper.toDomain(orderItemEntity);
    }

    @Override
    public Optional<OrderItem> findById(UUID id) {
        return orderItemJpaRepository.findById(id)
                .map(orderItemMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return orderItemJpaRepository.existsById(id);
    }

    @Override
    public PageData<OrderItem> findAll(Integer pageNumber, Integer pageSizeInteger) {
        return null;
    }

    @Override
    public void delete(OrderItem domain, boolean logical) {

    }

    @Override
    public List<OrderItem> saveAll(List<OrderItem> items) {
        return orderItemJpaRepository.saveAll(items.stream().map(orderItemMapper::toEntity).toList())
                .stream().map(orderItemMapper::toDomain).toList();
    }
}
