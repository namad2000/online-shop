package ir.online.shop.application.port.in.validator;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainValidator;
import ir.online.shop.application.port.in.model.cmd.order.CreateOrderItemCmd;

import java.util.List;

import static ir.online.shop.domain.exception.OrderExceptionCode.ORDER_ITEMS_NOT_EMPTY;

@DomainValidator
public class OrderValidator {

    public void checkIfItemsEmpty(List<CreateOrderItemCmd> items) {
        if (items.isEmpty()) {
            throw DomainException.of(ORDER_ITEMS_NOT_EMPTY);
        }
    }
}
