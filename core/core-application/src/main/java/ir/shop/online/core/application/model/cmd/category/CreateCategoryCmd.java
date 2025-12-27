package ir.shop.online.core.application.model.cmd.category;


import ir.shop.online.commons.domain.validation.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryCmd {

    @NotEmpty
    private String title;

    private String description;

    private Integer parentId;
}
