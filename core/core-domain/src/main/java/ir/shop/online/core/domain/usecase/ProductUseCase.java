package ir.shop.online.core.domain.usecase;

import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.domain.model.result.product.ProductResult;

public interface ProductUseCase {
    ProductResult create(CreateProductCmd createProductCmd);

    Product getById(Long productId);
}
