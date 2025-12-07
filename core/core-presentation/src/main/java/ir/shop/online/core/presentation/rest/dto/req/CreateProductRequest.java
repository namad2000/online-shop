package ir.shop.online.core.presentation.rest.dto.req;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank(message = "عنوان محصول نمی‌تواند خالی باشد")
    private String title;

    @NotNull(message = "قیمت محصول نمی‌تواند خالی باشد")
    private BigDecimal price;

    private String description;

    @Min(value = 0, message = "موجودی نمی‌تواند منفی باشد")
    private Integer stock;

    @NotNull(message = "دسته‌بندی نمی‌تواند خالی باشد")
    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
