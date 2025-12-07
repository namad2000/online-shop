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
public class CreateUser {

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    private String firstname;
    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    private String lastname;
    @NotBlank(message = "شماره همراه نمی‌تواند خالی باشد")
    private String mobile;

    private String email;

    private String password;

    private String role;
}
