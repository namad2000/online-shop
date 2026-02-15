package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface CustomerExceptionCode extends ExceptionCode {

    String CUSTOMER_NOT_FOUND = "CUSTOMER_01";
    String CUSTOMER_IS_DUPLICATED = "CUSTOMER_02";
}
