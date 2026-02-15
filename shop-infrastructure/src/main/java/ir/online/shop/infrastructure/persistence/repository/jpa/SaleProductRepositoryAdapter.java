package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.domain.repository.jpa.SaleProductRepository;
import ir.online.shop.infrastructure.persistence.entity.SaleProductEntity;
import ir.online.shop.infrastructure.persistence.mapper.SaleProductMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.SaleProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SaleProductRepositoryAdapter implements SaleProductRepository {

    private final SaleProductJpaRepository saleProductJpaRepository;
    private final SaleProductMapper saleProductMapper;

    @Override
    public boolean existsByProductIdAndVendorId(UUID productId, UUID vendorId) {
        return saleProductJpaRepository.existsByProduct_IdAndVendor_Id(productId, vendorId);
    }

    @Override
    public Optional<SaleProduct> findByIdActiveAndNotDeleted(UUID saleProductId) {
        return saleProductJpaRepository.findByIdAndIsActiveAndIsDeletedFalse(saleProductId, Boolean.TRUE)
                .map(saleProductMapper::toDomain);
    }

    @Override
    public PageData<SaleProduct> findByNameAndPriceRangeActiveAndNotDeleted(
            String name,
            Long minPrice,
            Long maxPrice,
            Integer pageNumber, Integer pageSize
    ) {
        Page<SaleProductEntity> page = saleProductJpaRepository.findByNameAndPriceRangeActiveAndNotDeleted(
                name,
                minPrice,
                maxPrice,
                PageRequest.of(pageNumber, pageSize)
        );

        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent()
                        .stream().map(saleProductMapper::toDomain).toList());
    }


    @Override
    public SaleProduct save(SaleProduct saleProduct) {
        SaleProductEntity saleProductEntity = saleProductMapper.toEntity(saleProduct);
        saleProductEntity = saleProductJpaRepository.save(saleProductEntity);

        return saleProductMapper.toDomain(saleProductEntity);
    }

    @Override
    public Optional<SaleProduct> findById(UUID id) {
        return saleProductJpaRepository.findById(id)
                .map(saleProductMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return saleProductJpaRepository.existsById(id);
    }

    @Override
    public PageData<SaleProduct> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(SaleProduct domain, boolean logical) {

    }
}
