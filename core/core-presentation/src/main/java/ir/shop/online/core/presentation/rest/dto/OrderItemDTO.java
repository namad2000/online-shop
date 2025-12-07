package ir.shop.online.core.presentation.rest.dto;


import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;

    @NotNull(message = "شناسه سفارش نمی‌تواند خالی باشد")
    private Long orderId;

    @NotNull(message = "شناسه محصول نمی‌تواند خالی باشد")
    private Long productId;

    @NotBlank(message = "عنوان محصول نمی‌تواند خالی باشد")
    private String productTitle;

    @NotNull(message = "قیمت واحد نمی‌تواند خالی باشد")
    @DecimalMin(value = "0.0", inclusive = false, message = "قیمت واحد باید بزرگتر از صفر باشد")
    private BigDecimal unitPrice;

    @Min(value = 1, message = "تعداد باید حداقل ۱ باشد")
    private Integer quantity;

    @NotNull(message = "قیمت کل نمی‌تواند خالی باشد")
    @DecimalMin(value = "0.0", message = "قیمت کل نمی‌تواند منفی باشد")
    private BigDecimal totalPrice;
}
