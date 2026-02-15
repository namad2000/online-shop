package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.repository.jpa.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static ir.online.shop.domain.exception.ProductExceptionCode.*;


/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.online.shop.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product newProduct, Category category, Brand brand) {
        newProduct.setCategory(category);
        newProduct.setBrand(brand);

        if (productRepository.existsBySku(newProduct.getSku())) {
            throw DomainException.withParams(PRODUCT_SKU_IS_DUPLICATED, newProduct.getSku());
        }

        boolean exists = productRepository.existsByNameAndCategory(newProduct.getName(), category);
        if (exists) {
            throw DomainException.withParams(PRODUCT_EXIST_IN_CATEGORY, newProduct.getName(), category);
        }

        return productRepository.save(newProduct);
    }

    public Product getById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> DomainException.of(PRODUCT_NOT_FOUND));
    }
}
