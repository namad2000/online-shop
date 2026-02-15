package ir.online.shop.presentation.rest.dto.res.product;

import ir.online.shop.presentation.rest.dto.res.media.MediaResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductResponse {

    private UUID id;

    private String name;

    private String description;

    private UUID categoryId;

    private String categoryName;

    private UUID brandId;

    private String brandName;

    private List<MediaResponse> medias;

    private String sku;

}
