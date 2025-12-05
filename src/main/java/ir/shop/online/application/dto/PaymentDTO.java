package ir.shop.online.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "مبلغ پرداخت نمی‌تواند خالی باشد")
    @DecimalMin(value = "1000.0", message = "مبلغ پرداخت باید حداقل ۱۰۰۰ تومان باشد")
    private BigDecimal amount;

    private LocalDateTime paymentDate;

    @NotBlank(message = "نوع پرداخت نمی‌تواند خالی باشد")
    private String paymentType; // ONLINE, CASH_ON_DELIVERY, CARD, WALLET, etc.

    private String bankTransactionCode;

    @NotBlank(message = "وضعیت پرداخت نمی‌تواند خالی باشد")
    private String status; // PENDING, SUCCESS, FAILED, CANCELLED, REFUNDED

    private String gatewayName; // ZARINPAL, SADAD, SAMAN, etc.

    private String refNumber;

    private String maskedCardNumber;

    private String trackingCode;

    @NotNull(message = "شناسه سفارش نمی‌تواند خالی باشد")
    private Long orderId;

    // اطلاعات سفارش مرتبط
    private String orderNumber;
}
