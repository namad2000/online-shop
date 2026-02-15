package ir.online.shop.presentation.rest.dto.res.category;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryResponse {

    private UUID id;
    private String name;
    private String slug;
    private Integer orderIndex;
    @Builder.Default
    private List<CategoryResponse> children = new ArrayList<>(); // maxDepth = 1 or 2

//    private UUID id;
//
//    private String name;
//
//    private String description;
//
//    private Integer level;
//
//    private CategoryResponse parent;
//
//    private Set<CategoryResponse> children = new HashSet<>();
}
