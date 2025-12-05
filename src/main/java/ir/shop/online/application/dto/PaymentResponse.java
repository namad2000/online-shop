package ir.shop.online.application.dto;


import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private boolean success;
    private String message;
    private String paymentId;
    private String authority; // برای درگاه‌هایی مانند زرین‌پال
    private String paymentUrl; // URL برای هدایت به درگاه پرداخت
    private String refId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String trackingCode;
    private Long orderId;

    // اطلاعات اضافی
    private String gatewayName;
    private String cardPan; // 4 رقم آخر کارت
    private String customerName;
}
