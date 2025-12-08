package ir.shop.online.core.domain.model.product;


import ir.shop.online.core.domain.model.ProductImage;
import ir.shop.online.core.domain.model.category.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product {
    private String name;

    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private String sku; // شناسه محصول

    private Category category;

    @Builder.Default
    private Set<ProductImage> images = new HashSet<>();
}
