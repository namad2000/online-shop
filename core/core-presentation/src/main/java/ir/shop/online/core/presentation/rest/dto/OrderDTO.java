package ir.shop.online.core.presentation.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    private String customerFirstName;

    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    private String customerLastName;

    @Pattern(regexp = "^09[0-9]{9}$", message = "شماره موبایل معتبر نیست")
    private String customerMobile;

    private LocalDateTime orderDate;

    private String status;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    private String address;

    private Long userId;

    private List<OrderItemDTO> orderItems;

    private PaymentDTO payment;
}
