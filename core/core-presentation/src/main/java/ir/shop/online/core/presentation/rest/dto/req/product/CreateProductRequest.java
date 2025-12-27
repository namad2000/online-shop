package ir.shop.online.core.presentation.rest.dto.req.product;

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
public class CreateProductRequest {

    private String title;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
