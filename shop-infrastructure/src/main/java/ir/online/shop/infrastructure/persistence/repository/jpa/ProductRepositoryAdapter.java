package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.repository.jpa.ProductRepository;
import ir.online.shop.infrastructure.persistence.entity.ProductEntity;
import ir.online.shop.infrastructure.persistence.mapper.ProductMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public boolean existsByNameAndCategory(String name, Category category) {
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
    public Optional<Product> findById(UUID id) {
        return productJpaRepository.findById(id)
                .map(productMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return productJpaRepository.existsById(id);
    }

    @Override
    public PageData<Product> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(Product domain, boolean logical) {

    }
}
