package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.infrastructure.persistence.entity.SaleProductEntity;
import ir.online.shop.infrastructure.persistence.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendorJpaRepository extends JpaRepository<VendorEntity, UUID> {
}
