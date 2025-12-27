package ir.shop.online.core.infrastructure.persistence.repository.jpa.spring;


import ir.shop.online.core.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsBySku(String sku);
}
