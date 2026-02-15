package ir.online.shop.application.port.in.model.cmd.address;


import io.qoop.validation.api.IsValid;
import ir.online.shop.domain.model.Customer;
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
    private Customer customer;
    private String postalCode;

    private Boolean isDefault = false;
}
