package ir.online.shop.application.port.in.model.cmd.brand;


import io.qoop.validation.api.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandCmd {

    @NotEmpty
    private String name;
    private String description;
    private String country;
    private String slug;
    private UUID logoId;
}
