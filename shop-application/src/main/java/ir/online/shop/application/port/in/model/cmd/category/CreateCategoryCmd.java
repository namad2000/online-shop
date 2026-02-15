package ir.online.shop.application.port.in.model.cmd.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryCmd {

    private String name;
    private String description;
    private String slug;
    private Boolean featured;
    private Integer orderIndex;
    private UUID parentId;
    private UUID mediaId;
}
