package ir.shop.online.core.domain.model.category;


import ir.shop.online.commons.domain.validation.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategory {

    @NotEmpty
    private String title;

    private String description;

    private Integer parentId;
}
