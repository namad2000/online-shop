package ir.shop.online.core.domain.model.category;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategory {

    @NotBlank(message = "عنوان دسته‌بندی نمی‌تواند خالی باشد")
    private String title;

    private String description;

    private Integer parentId;
}
