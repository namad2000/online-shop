package ir.online.shop.application.port.in.model.result.product;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductResult extends UpdateModel<UUID> {

    private String name;

    private String description;

    private String sku;

    private UUID categoryId;

    private String categoryName;

    private UUID brandId;

    private String brandName;

    private List<MediaResult> medias;
}
