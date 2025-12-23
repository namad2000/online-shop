package ir.shop.online.core.presentation.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long id;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private String paymentType; // ONLINE, CASH_ON_DELIVERY, CARD, WALLET, etc.

    private String bankTransactionCode;

    private String status; // PENDING, SUCCESS, FAILED, CANCELLED, REFUNDED

    private String gatewayName; // ZARINPAL, SADAD, SAMAN, etc.

    private String refNumber;

    private String maskedCardNumber;

    private String trackingCode;

    private Long orderId;

    // اطلاعات سفارش مرتبط
    private String orderNumber;
}
