package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface VendorExceptionCode extends ExceptionCode {

    String VENDOR_NOT_FOUND = "VENDOR_01";
    String VENDOR_IS_DUPLICATED = "VENDOR_02";
}
