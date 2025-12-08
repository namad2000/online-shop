package ir.shop.online.core.domain.model.address;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {


    private String firstname;

    private String lastname;

    private String mobile;

    private String email;

    private String password;

    private String role;
}
