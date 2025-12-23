package ir.shop.online.core.domain.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProduct {

    private String title;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
