package ir.shop.online.core.application.mapper;

import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.util.mapper.MappingContext;
import ir.shop.online.core.application.model.result.product.ProductResult;
import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.model.ProductImage;

import java.util.stream.Collectors;

@DomainMapper
public class ProductResultMapper {

    @Override
    public ProductResult map(Product product, MappingContext context) {
        return ProductResult.builder()
                .id(product.getId())
                .title(product.getName())
                .price(product.getPrice())
                .stock(product.getStockQuantity())
                .imageUrls(product.getImages().stream().map(ProductImage::getUrl).collect(Collectors.toList()))
                .sku(product.getSku())
                .description(product.getDescription())
                .build();
    }
}
