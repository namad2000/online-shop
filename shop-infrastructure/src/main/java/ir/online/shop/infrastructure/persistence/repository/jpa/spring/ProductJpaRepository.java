package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
    boolean existsBySku(String sku);
}
