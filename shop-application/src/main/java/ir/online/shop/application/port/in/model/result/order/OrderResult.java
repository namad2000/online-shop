package ir.online.shop.application.port.in.model.result.order;

import io.qoop.domain.model.UpdateModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OrderResult extends UpdateModel<UUID> {

    private LocalDateTime orderDate;

    //    private Customer customer;
//
//    private Vendor vendor;
//
//    private String address;
//
//    private String postalCode;
//
//    private String mobile;
//
//    @Builder.Default
    private List<OrderItemResult> items = new ArrayList<>();

    private int totalItems;

    private BigDecimal totalPrice;
}
