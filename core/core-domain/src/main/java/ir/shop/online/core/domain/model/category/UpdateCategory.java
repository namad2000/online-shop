package ir.shop.online.core.domain.model.category;


import ir.shop.online.commons.domain.model.Version;
import ir.shop.online.commons.domain.validation.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCategory extends Version<Integer> {

    @NotEmpty
    private String title;

    private String description;

    private Integer parentId;
}
