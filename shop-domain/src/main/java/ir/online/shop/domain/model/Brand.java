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
public class Brand extends DeleteModel<UUID> {

    private String name;

    private String description;

    private String country;

    private String slug;

    @Builder.Default
    private Set<Media> medias = new HashSet<>();

    public Media getLogo() {
        return medias.stream().filter(x -> x.isMain() && x.getMediaType() == MediaType.IMAGE).findFirst()
                .orElse(null);
    }
}
