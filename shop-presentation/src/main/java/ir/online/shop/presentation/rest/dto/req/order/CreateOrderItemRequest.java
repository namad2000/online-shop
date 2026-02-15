package ir.online.shop.presentation.rest.dto.req.order;

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
public class CreateOrderItemRequest {

   private UUID saleProductId;
   private int quantity;
   private BigDecimal pricePerUnit;
}
