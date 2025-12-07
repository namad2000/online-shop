package ir.shop.online.application.dto.req;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {

    @NotBlank(message = "عنوان آدرس نمی‌تواند خالی باشد")
    private String title;

    @NotBlank(message = "آدرس نمی‌تواند خالی باشد")
    private String address;

    private String postalCode;

    private Boolean isDefault = false;
}
