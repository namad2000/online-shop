package ir.shop.online.core.presentation.rest.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "عنوان محصول نمی‌تواند خالی باشد")
    @Size(min = 2, max = 255, message = "عنوان محصول باید بین ۲ تا ۲۵۵ کاراکتر باشد")
    private String title;

    @NotNull(message = "قیمت محصول نمی‌تواند خالی باشد")
    @DecimalMin(value = "0.0", inclusive = false, message = "قیمت باید بزرگتر از صفر باشد")
    private BigDecimal price;

    private String description;

    @Min(value = 0, message = "موجودی نمی‌تواند منفی باشد")
    private Integer stock;

    @NotNull(message = "دسته‌بندی نمی‌تواند خالی باشد")
    private Long categoryId;

    private String categoryTitle;
}
