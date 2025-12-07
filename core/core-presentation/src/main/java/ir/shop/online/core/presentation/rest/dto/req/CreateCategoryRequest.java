package ir.shop.online.core.presentation.rest.dto.req;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "عنوان دسته‌بندی نمی‌تواند خالی باشد")
    private String title;

    private String description;

    private Integer parentId;
}
