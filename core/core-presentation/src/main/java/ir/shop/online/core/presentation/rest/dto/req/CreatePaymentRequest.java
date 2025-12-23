package ir.shop.online.core.presentation.rest.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {

    private Long orderId;

    private BigDecimal amount;

    private String paymentType;

    private String bankTransactionCode;

    private String refNumber;

    private String gatewayName;

    // برای پرداخت آنلاین
    private String callbackUrl;

    // برای پرداخت کارتی
    private String cardNumber;

    // برای پرداخت نقدی هنگام تحویل
    private Boolean cashOnDelivery = false;
}
