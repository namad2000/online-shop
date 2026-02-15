package ir.online.shop.application.port.in.model.result.category;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryResult extends UpdateModel<UUID> {

    private String name;
    private String slug;
    private Boolean active;
    private Boolean featured;
    private Integer orderIndex;
    private String description;
    private UUID parentId;

    private Set<CategoryResult> children = new HashSet<>();

    private MediaResult media;
}
