package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface MediaExceptionCode extends ExceptionCode {

    String MEDIA_NOT_FOUND = "MEDIA_01";
    String MEDIA_IS_DUPLICATED = "MEDIA_02";
    String MEDIA_TYPE_NOT_SUPPORTED = "MEDIA_03";
}
