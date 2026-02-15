package ir.online.shop.domain.model;

import io.qoop.domain.model.DeleteModel;
import ir.online.shop.domain.model.enums.MediaType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Category extends DeleteModel<UUID> {

    private String name;

    private String description;

    private String slug;

    private boolean active = true;

    private boolean deleted;

    private boolean featured;

    private Integer orderIndex;

    private Category parent;

    private Set<Category> children = new HashSet<>();

    @Builder.Default
    private Set<Media> medias = new HashSet<>();

    public Media getMainImage() {
        return medias.stream().filter(x -> x.isMain() && x.getMediaType() == MediaType.IMAGE).findFirst()
                .orElse(null);
    }
}
