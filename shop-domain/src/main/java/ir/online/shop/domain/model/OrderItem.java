package ir.online.shop.domain.model;


import io.qoop.domain.model.DeleteModel;
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
public class OrderItem extends DeleteModel<UUID> {

    private OrderHead orderHead;

    private SaleProduct saleProduct;

    private Integer quantity;

    private BigDecimal pricePerUnit;

    private BigDecimal totalPrice;
}
