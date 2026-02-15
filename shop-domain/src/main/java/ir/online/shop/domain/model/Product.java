package ir.online.shop.domain.model;


import io.qoop.domain.model.DeleteModel;
import io.qoop.fault.handler.api.exception.DomainException;
import ir.online.shop.domain.model.enums.MediaType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static ir.online.shop.domain.exception.ProductExceptionCode.PRODUCT_MAIN_THUMBNAIL_NOT_FOUND;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product extends DeleteModel<UUID> {

    private String name;

    private String description;

    private Integer stockQuantity;

    private String sku;

    private Brand brand;

    private Category category;

    @Builder.Default
    private Set<Media> medias = new HashSet<>();

    public Media getMainThumbnailImage() {
        return medias.stream().filter(x ->
                        x.isMain() &&
                                x.getMediaType() == MediaType.IMAGE &&
                                x.isThumbnail()
                ).findFirst()
                .orElseThrow(() -> DomainException.of(PRODUCT_MAIN_THUMBNAIL_NOT_FOUND));
    }
}
