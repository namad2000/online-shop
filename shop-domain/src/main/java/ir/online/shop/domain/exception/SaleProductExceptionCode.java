package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface SaleProductExceptionCode extends ExceptionCode {

    String SALE_PRODUCT_NOT_FOUND = "SALE_PRODUCT_01";

    String SALE_PRODUCT_IS_DUPLICATED = "SALE_PRODUCT_02";
    String SALE_PRODUCT_PRICE_ORIGINAL_LESS_THAN = "SALE_PRODUCT_03";
}
