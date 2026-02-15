package ir.online.shop.presentation.rest.dto.req.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    private String name;

    private String description;

    private UUID brandId;

    private UUID categoryId;

    private List<String> imageUrls;

    private String sku;
}
