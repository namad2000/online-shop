package ir.shop.online.core.domain.usecase;

import ir.shop.online.application.dto.req.CreateProductRequest;
import ir.shop.online.domain.model.entity.Product;

public interface ProductUseCase {
    Product create(CreateProductRequest request);

    Product getById(Long productId);
}
