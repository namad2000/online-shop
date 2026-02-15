package ir.online.shop.domain.exception;


import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface ProductExceptionCode extends ExceptionCode {

    String PRODUCT_NOT_FOUND = "PRODUCT_01";
    String PRODUCT_EXIST_IN_CATEGORY = "PRODUCT_02";
    String PRODUCT_SKU_IS_DUPLICATED = "PRODUCT_03";
    String PRODUCT_MAIN_THUMBNAIL_NOT_FOUND = "PRODUCT_04";
}
