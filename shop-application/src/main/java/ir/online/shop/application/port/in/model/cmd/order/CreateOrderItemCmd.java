package ir.online.shop.application.port.in.model.cmd.order;

import io.qoop.validation.api.Min;
import io.qoop.validation.api.NotNull;
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
public class CreateOrderItemCmd {

    @NotNull
    private UUID saleProductId;
    @Min(1)
    private int quantity;
    @NotNull
    private BigDecimal pricePerUnit;
}
