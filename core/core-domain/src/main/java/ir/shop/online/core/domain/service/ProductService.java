package ir.shop.online.core.domain.service;

import ir.shop.online.commons.domain.annotation.DomainService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.core.domain.exception.ProductExceptionCode;
import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.repository.jpa.ProductRepository;
import lombok.RequiredArgsConstructor;

import static ir.shop.online.core.domain.exception.ProductExceptionCode.PRODUCT_03;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.shop.online.core.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product newProduct) {
        if (productRepository.existsBySku(newProduct.getSku())) {
            throw new DomainException(PRODUCT_03.name());
        }

        boolean exists = productRepository.existsByNameAndCategory(newProduct.getName(), newProduct.getCategory());
        if (exists) {
            throw new DomainException(ProductExceptionCode.PRODUCT_02.name()); // محصول با این نام در دسته موجود است
        }

        return productRepository.save(newProduct);
    }

    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new DomainException(ProductExceptionCode.PRODUCT_02.name()));
    }
}
