package ir.shop.online.core.application.model.cmd.address;


import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddress {

    private String title;

    private String address;

    @IsValid
    private User user;
    private String postalCode;

    private Boolean isDefault = false;
}
