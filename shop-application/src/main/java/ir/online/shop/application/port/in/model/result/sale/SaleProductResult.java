package ir.online.shop.application.port.in.model.result.sale;

import io.qoop.domain.model.UpdateModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SaleProductResult extends UpdateModel<UUID> {

    private String vendorCommerceName;

    private UUID productId;

    private String productName;

    private String thumbnailImageUrl;

    private BigDecimal originalRetailPrice;

    private BigDecimal retailPrice;

    private Boolean allowNegativeStock;

    private Integer stockQuantity;
}
