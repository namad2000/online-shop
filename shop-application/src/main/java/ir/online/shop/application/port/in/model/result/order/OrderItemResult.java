package ir.online.shop.application.port.in.model.result.order;

import io.qoop.domain.model.UpdateModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OrderItemResult extends UpdateModel<UUID> {

    private UUID saleProductId;
    private String productName;
    private Integer quantity;
    private BigDecimal pricePerUnit;
}
