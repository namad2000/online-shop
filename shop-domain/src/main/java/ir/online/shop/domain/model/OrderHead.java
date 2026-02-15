package ir.online.shop.domain.model;


import io.qoop.domain.model.DeleteModel;
import ir.online.shop.domain.model.enums.OrderStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderHead extends DeleteModel<UUID> {

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    private Customer customer;

    private Vendor vendor;

    private String address;

    private String postalCode;

    private String mobile;

    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    private int totalItems;

    private BigDecimal totalPrice;
}
