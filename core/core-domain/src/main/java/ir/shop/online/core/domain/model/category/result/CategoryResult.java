package ir.shop.online.core.domain.model.category.result;

import ir.shop.online.commons.domain.model.Version;
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
public class CategoryResult extends Version<Integer> {

    private String title;

    private String description;

    private Integer level;

    private CategoryResult parent;

    private Set<CategoryResult> children = new HashSet<>();
}
