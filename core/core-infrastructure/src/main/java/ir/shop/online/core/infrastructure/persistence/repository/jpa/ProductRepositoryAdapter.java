package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.repository.jpa.ProductRepository;
import ir.shop.online.core.infrastructure.persistence.entity.ProductEntity;
import ir.shop.online.core.infrastructure.persistence.mapper.ProductMapper;
import ir.shop.online.core.infrastructure.persistence.repository.jpa.spring.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public boolean existsByNameAndCategory(String title, Category category) {
        return false;
    }

    @Override
    public boolean existsBySku(String sku) {
        return productJpaRepository.existsBySku(sku);
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        productEntity = productJpaRepository.save(productEntity);

        return productMapper.toDomain(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(productMapper::toDomain);
    }

    @Override
    public Boolean existById(Long id) {
        return productJpaRepository.existsById(id);
    }
}
