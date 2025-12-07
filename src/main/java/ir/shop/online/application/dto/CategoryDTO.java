package ir.shop.online.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "عنوان دسته‌بندی نمی‌تواند خالی باشد")
    private String title;

    private String description;

    private Integer level;

    private Long parentId;
    private String parentTitle;

//    private Integer productCount;
}
