package ir.shop.online.application.dto;


import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    private String customerFirstName;

    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    private String customerLastName;

    @Pattern(regexp = "^09[0-9]{9}$", message = "شماره موبایل معتبر نیست")
    private String customerMobile;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    private String address;

    private Long userId;

    private Long addressId;

    @NotEmpty(message = "سفارش باید حداقل یک آیتم داشته باشد")
    private List<OrderItemRequest> items;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemRequest {

        @NotNull(message = "شناسه محصول نمی‌تواند خالی باشد")
        private Long productId;

        @Min(value = 1, message = "تعداد باید حداقل ۱ باشد")
        private Integer quantity;
    }
}
