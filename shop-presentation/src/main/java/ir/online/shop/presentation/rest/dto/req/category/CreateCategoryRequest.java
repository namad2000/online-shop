package ir.online.shop.presentation.rest.dto.req.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    private String name;
    private String description;
    private String slug;
    private Boolean featured;
    private Integer orderIndex;
    private UUID parentId;
    private UUID mediaId;
}
