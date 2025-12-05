package ir.shop.online.application.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "نام نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "نام باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    private String firstName;

    @NotBlank(message = "نام خانوادگی نمی‌تواند خالی باشد")
    @Size(min = 2, max = 100, message = "نام خانوادگی باید بین ۲ تا ۱۰۰ کاراکتر باشد")
    private String lastName;

    @Pattern(regexp = "^09[0-9]{9}$", message = "شماره موبایل معتبر نیست")
    private String mobileNumber;

    @Email(message = "ایمیل معتبر نیست")
    private String email;

    private String password; // فقط برای ایجاد کاربر جدید

    private Set<String> roles;

    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    // آدرس‌های کاربر
    // private List<AddressDTO> addresses;
}
