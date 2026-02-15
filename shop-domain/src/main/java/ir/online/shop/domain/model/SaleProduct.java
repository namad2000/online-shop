package ir.online.shop.domain.model;


import io.qoop.domain.model.DeleteModel;
import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.utils.api.BigDecimalUtil;
import ir.online.shop.domain.exception.SaleProductExceptionCode;
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
public class SaleProduct extends DeleteModel<UUID> {

    private Product product;

    private Vendor vendor;

    private BigDecimal originalRetailPrice;

    private BigDecimal retailPrice;

    private Boolean allowNegativeStock;

    private Integer stockQuantity;


    public void checkIfPriceGreaterThanOriginal() {
        if (BigDecimalUtil.greaterThan(retailPrice, originalRetailPrice)) {
            throw DomainException.withParams(SaleProductExceptionCode.SALE_PRODUCT_PRICE_ORIGINAL_LESS_THAN, retailPrice, originalRetailPrice);
        }
    }
}
