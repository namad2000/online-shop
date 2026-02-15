package ir.online.shop.domain.exception;

import io.qoop.fault.handler.api.exception.ExceptionCode;

public interface CategoryExceptionCode extends ExceptionCode {

    String CATEGORY_NOT_FOUND = "CATEGORY_01";
    String CATEGORY_IS_DUPLICATE = "CATEGORY_02";
    String ONLY_ONE_CATEGORY_CAN_EXIST_WITHOUT_PARENT = "CATEGORY_03";
    String PARENT_IS_INVALID = "CATEGORY_04";
    String CYCLE_NOT_ALLOWED = "CATEGORY_05";


}
