package ir.shop.online.core.domain.model.product;


import ir.shop.online.commons.domain.model.Version;
import ir.shop.online.commons.domain.validation.NotEmpty;
import ir.shop.online.commons.domain.validation.NotNull;
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
public class Product extends Version<Long> {

    @NotEmpty
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stockQuantity;

    @NotEmpty
    private String sku; // شناسه محصول

    @NotEmpty
    private Category category;

    @Builder.Default
    private Set<ProductImage> images = new HashSet<>();
}
