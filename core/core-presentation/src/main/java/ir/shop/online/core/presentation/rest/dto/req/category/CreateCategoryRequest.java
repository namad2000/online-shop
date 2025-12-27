package ir.shop.online.core.presentation.rest.dto.req.category;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    private String title;

    private String description;

    private Integer parentId;
}
