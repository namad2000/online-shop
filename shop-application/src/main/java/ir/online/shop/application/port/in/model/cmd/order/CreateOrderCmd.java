package ir.online.shop.application.port.in.model.cmd.order;

import io.qoop.validation.api.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderCmd {

    private UUID customerId;
    @NotEmpty
    private String address;
    @NotEmpty
    private String postalCode;
    @NotEmpty
    private String mobile;
    private List<CreateOrderItemCmd> items;
}
