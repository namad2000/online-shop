package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.product.cmd.CreateProductCmd;
import ir.shop.online.core.domain.model.product.Product;
import ir.shop.online.core.domain.model.product.result.CreateProductResult;

public interface ProductUseCase {
    CreateProductResult create(CreateProductCmd createProductCmd);

    Product getById(Long productId);
}
