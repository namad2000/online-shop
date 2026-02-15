package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface OrderExceptionCode extends ExceptionCode {
    String ORDER_NOT_FOUND = "ORDER_01";
    String ORDER_IS_DUPLICATED = "ORDER_02";
    String ORDER_ITEMS_NOT_EMPTY = "ORDER_03";
}
