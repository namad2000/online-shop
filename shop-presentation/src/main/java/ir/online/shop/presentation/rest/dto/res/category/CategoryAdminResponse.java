package ir.online.shop.presentation.rest.dto.res.category;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryAdminResponse {

    private UUID id;
    private String name;
    private String slug;
    private Boolean active;
    private Boolean featured;
    private Integer orderIndex;
    private String description;
    private UUID parentId;
    @Builder.Default
    private List<CategoryResponse> children = new ArrayList<>(); // limited maxDepth for ex: 3
}
