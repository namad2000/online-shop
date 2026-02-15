package ir.online.shop.application.port.in.model.cmd.brand;

import io.qoop.domain.model.UpdateModel;
import io.qoop.validation.api.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateBrandCmd extends UpdateModel<UUID> {

    @NotEmpty
    private String name;
    private String description;
    private String country;
    private UUID logoId;
}
