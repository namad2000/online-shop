package ir.online.shop.application.port.in.model.cmd.product;

import io.qoop.validation.api.NotEmpty;
import io.qoop.validation.api.NotNull;
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
public class CreateProductCmd {

    @NotEmpty
    private String name;

    private String description;

//    @NotNull
    private UUID brandId;

    @NotNull
    private UUID categoryId;

    private List<String> imageUrls;

    private String sku;
}
