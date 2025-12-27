package ir.shop.online.core.domain.model.cmd.product;

import ir.shop.online.commons.domain.validation.Min;
import ir.shop.online.commons.domain.validation.NotEmpty;
import ir.shop.online.commons.domain.validation.NotNull;
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
public class CreateProductCmd {

    @NotEmpty
    private String title;

    @NotNull
    @Min(0)
    private BigDecimal price;

    private String description;

    @NotNull
    @Min(0)
    private Integer stock;

    @NotNull
    private Integer categoryId;

    private List<String> imageUrls;

    private String sku;
}
