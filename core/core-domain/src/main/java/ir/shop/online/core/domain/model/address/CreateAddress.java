package ir.shop.online.core.domain.model.address;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddress {

    @NotBlank(message = "عنوان آدرس نمی‌تواند خالی باشد")
    private String title;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    private String address;

    private String postalCode;

    private Boolean isDefault = false;
}
