package ir.online.shop.presentation.rest.dto.req.sale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleProductRequest {

    private UUID productId;

//    @NotEmpty
//    private String sku;

    private UUID vendorId;

    private BigDecimal originalRetailPrice;

    private BigDecimal retailPrice;

    private Boolean allowNegativeStock;

    private Integer stockQuantity;
}
