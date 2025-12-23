package ir.shop.online.core.presentation.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

//    private String password; // فقط برای ایجاد کاربر جدید

    private Set<String> roles;

//    private Boolean isActive;

    private LocalDateTime createdAt;
//    private LocalDateTime lastLoginAt;

    // آدرس‌های کاربر
    private List<AddressDTO> addresses;
}
