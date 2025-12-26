package ir.shop.online.core.domain.model.product.result;

import ir.shop.online.commons.domain.validation.Min;
import ir.shop.online.commons.domain.validation.NotEmpty;
import ir.shop.online.commons.domain.validation.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateProductResult {

    private String title;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
