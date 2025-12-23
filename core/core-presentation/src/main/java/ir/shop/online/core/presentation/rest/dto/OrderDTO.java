package ir.shop.online.core.presentation.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private String customerFirstName;

    private String customerLastName;

    private String customerMobile;

    private LocalDateTime orderDate;

    private String status;

    private String address;

    private Long userId;

    private List<OrderItemDTO> orderItems;

    private PaymentDTO payment;
}
