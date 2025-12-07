package ir.shop.online.core.presentation.rest.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "شناسه سفارش نمی‌تواند خالی باشد")
    private Long orderId;

    @NotNull(message = "مبلغ پرداخت نمی‌تواند خالی باشد")
    @DecimalMin(value = "1000.0", message = "مبلغ پرداخت باید حداقل ۱۰۰۰ تومان باشد")
    private BigDecimal amount;

    @NotBlank(message = "نوع پرداخت نمی‌تواند خالی باشد")
    private String paymentType;

    @NotBlank(message = "کد تراکنش بانک نمی تواند خالی باشد.")
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
