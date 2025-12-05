package ir.shop.online.application.dto.req;


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

    private Long parentId;
}
