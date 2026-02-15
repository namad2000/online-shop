package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.product.CreateProductCmd;
import ir.online.shop.application.port.in.model.result.product.ProductResult;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Product;

@DomainMapper
public class ProductMapper implements InputMapper<CreateProductCmd, Product>, ResultMapper<Product, ProductResult> {

    @Override
    public Product toDomain(CreateProductCmd cmd, MappingContext context) {
        return Product.builder()
                .name(cmd.getName())
                .description(cmd.getDescription())
                .sku(cmd.getSku())
                .brand(cmd.getBrandId() == null ? null : Brand.builder().id(cmd.getBrandId()).build())
                .category(cmd.getCategoryId() == null ? null : Category.builder().id(cmd.getCategoryId()).build())
                .build();
    }

    @Override
    public ProductResult toResult(Product product, MappingContext context) {
        return ProductResult.builder()
                .id(product.getId())
                .brandId(product.getBrand().getId())
                .brandName(product.getBrand().getName())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .build();
    }
}
