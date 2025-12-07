package ir.shop.online.core.presentation.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    @NotBlank(message = "عنوان نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "عنوان باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    private String title;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "آدرس باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    private String address;

    @Pattern(regexp = "^{10}$", message = "کد پستی معتبر نیست")
    private String postalCode;

    private Boolean isDefault;

}
