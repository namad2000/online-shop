package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.application.mapper.CreateProductMapper;
import ir.shop.online.core.application.mapper.ProductResultMapper;
import ir.shop.online.core.application.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.application.model.result.product.ProductResult;
import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService productService;
    private final ProductResultMapper productResultMapper;
    private final CreateProductMapper createProductMapper;

    public ProductResult create(@IsValid CreateProductCmd cmd) {
        Product product = createProductMapper.map(cmd);

        return productResultMapper.map(productService.create(product));
    }

    public ProductResult getById(Long productId) {
        return productService.getById(productId);
    }
}
