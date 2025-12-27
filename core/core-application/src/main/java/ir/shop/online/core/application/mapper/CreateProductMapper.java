package ir.shop.online.core.application.mapper;

import ir.shop.online.commons.domain.annotation.DomainMapper;
import ir.shop.online.commons.util.mapper.MappingContext;
import ir.shop.online.core.application.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.Product;

@DomainMapper
public class CreateProductMapper {

    @Override
    public Product map(CreateProductCmd cmd, MappingContext context) {
        return Product.builder()
                .name(cmd.getTitle())
                .price(cmd.getPrice())
                .sku(cmd.getSku())
                .stockQuantity(cmd.getStock())
                .category(Category.builder().id(cmd.getCategoryId()).build())
                .build();
    }
}
