package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface BrandExceptionCode extends ExceptionCode {
    String BRAND_NOT_FOUND = "BRAND_01";
    String BRAND_IS_DUPLICATE = "BRAND_02";
}
