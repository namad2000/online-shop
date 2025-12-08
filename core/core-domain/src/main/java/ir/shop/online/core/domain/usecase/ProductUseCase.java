package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.product.CreateProduct;
import ir.shop.online.core.domain.model.product.Product;

public interface ProductUseCase {
    Product create(CreateProduct createProduct);

    Product getById(Long productId);
}
