package ir.shop.online.core.domain.model.category;

import ir.shop.online.commons.domain.model.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Category extends Version<Integer> {

    @NotBlank(message = "عنوان نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "عنوان باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    private String title;

    private String description;


    private Integer level;

    private Category parent;

    @Builder.Default
    private Set<Category> children = new HashSet<>();
}
