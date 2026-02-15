package ir.online.shop.presentation.rest.dto.res.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SaleProductResponse {

    private UUID id;

    private String vendorCommerceName;

    private UUID productId;

    private String productName;

    private String thumbnailImageUrl;

    private String url;

    private Long price;

    private Integer stockQuantity;

}
