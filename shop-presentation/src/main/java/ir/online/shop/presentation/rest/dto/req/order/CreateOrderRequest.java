package ir.online.shop.presentation.rest.dto.req.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

   private UUID customerId;
   private String address;
   private String postalCode;
   private String mobile;
   private List<CreateOrderItemRequest> items;
}
