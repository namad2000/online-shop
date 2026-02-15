package ir.online.shop.application.port.in.model.cmd.sale;

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
public class CreateSaleProductCmd {

    @NotNull
    private UUID productId;

    private UUID vendorId;

    @NotNull
    private BigDecimal originalRetailPrice;

    private BigDecimal retailPrice;

    private Boolean allowNegativeStock;

    private Integer stockQuantity;
}
