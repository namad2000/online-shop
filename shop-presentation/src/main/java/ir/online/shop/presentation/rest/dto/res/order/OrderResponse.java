package ir.online.shop.presentation.rest.dto.res.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderResponse {

    private UUID id;

    private List<OrderItemResponse> items;

    private int totalItems;

    private BigDecimal totalPrice;
}
