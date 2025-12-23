package ir.shop.online.core.presentation.rest.dto.req;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private String customerFirstName;

    private String customerLastName;

    private String customerMobile;

    private String address;

    private Long userId;

    private Long addressId;

    private List<OrderItemRequest> items;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemRequest {

        private Long productId;

        private Integer quantity;
    }
}
