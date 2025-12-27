package ir.shop.online.core.presentation.rest.dto.res.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryResponse {

    private Integer id;

    private String title;

    private String description;

    private Integer level;

    private CategoryResponse parent;

    private Set<CategoryResponse> children = new HashSet<>();
}
