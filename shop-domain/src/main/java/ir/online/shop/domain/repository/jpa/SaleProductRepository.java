package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.model.PageData;
import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.SaleProduct;

import java.util.Optional;
import java.util.UUID;


public interface SaleProductRepository extends DomainRepository<SaleProduct, UUID> {
    boolean existsByProductIdAndVendorId(UUID productId, UUID vendorId);

    Optional<SaleProduct> findByIdActiveAndNotDeleted(UUID saleProductId);

    PageData<SaleProduct> findByNameAndPriceRangeActiveAndNotDeleted(
            String name,
            Long minPrice,
            Long maxPrice,
            Integer pageNumber,
            Integer pageSize
    );
}
