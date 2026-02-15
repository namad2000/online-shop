package ir.online.shop.presentation.rest.dto.res.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderItemResponse {

    private UUID id;
    private UUID saleProductId;
    private String productName;
    private Integer quantity;
    private BigDecimal pricePerUnit;
}
