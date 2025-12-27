package ir.shop.online.core.application.model.result.product;

import ir.shop.online.commons.domain.model.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductResult extends Version<Long> {

    private String title;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
