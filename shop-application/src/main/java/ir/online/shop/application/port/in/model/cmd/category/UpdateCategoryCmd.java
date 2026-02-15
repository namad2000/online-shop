package ir.online.shop.application.port.in.model.cmd.category;

import io.qoop.domain.model.UpdateModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCategoryCmd extends UpdateModel<UUID> {

    private String name;
    private String description;
    private String slug;
    private Boolean active;
    private Boolean featured;
    private Integer orderIndex;
    private UUID parentId;
    private UUID mediaId;
}
