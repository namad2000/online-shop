package ir.shop.online.core.domain.model.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProduct {

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
