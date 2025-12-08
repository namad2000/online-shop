package ir.shop.online.core.domain.model.address;


import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.model.user.User;
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

    @IsValid
    private User user;
    private String postalCode;

    private Boolean isDefault = false;
}
