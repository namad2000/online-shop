package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.infrastructure.persistence.entity.SaleProductEntity;
import ir.online.shop.infrastructure.persistence.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleProductJpaRepository extends JpaRepository<SaleProductEntity, UUID> {
    boolean existsByProduct_IdAndVendor_Id(UUID productId, UUID vendorId);

    Optional<SaleProductEntity> findByIdAndIsActiveAndIsDeletedFalse(UUID id, Boolean isActive);

    @Query(value =
            """
            select s from SaleProductEntity s
            where s.isActive = TRUE
              AND s.isDeleted != TRUE
              AND s.retailPrice >= :minPrice
              AND s.retailPrice <= :maxPrice
              AND s.product.name like %:name%
            """)
    Page<SaleProductEntity> findByNameAndPriceRangeActiveAndNotDeleted(
            @Param("name") String name,
            @Param("minPrice") Long minPrice,
            @Param("maxPrice") Long maxPrice,
            Pageable pageable);
}
