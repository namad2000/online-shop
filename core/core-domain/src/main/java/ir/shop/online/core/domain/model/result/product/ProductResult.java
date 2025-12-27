package ir.shop.online.core.domain.model.result.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductResult {

    private String title;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
