package ir.shop.online.application.service;

import ir.shop.online.application.dto.req.CreateProductRequest;
import ir.shop.online.domain.model.entity.Product;

public interface ProductService {
    Product create(CreateProductRequest request);

    Product getById(Long productId);
}
