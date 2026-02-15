package ir.online.shop.presentation.rest.dto.req.brand;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest {

    private String name;
    private String description;
    private String country;
    private String slug;
    private UUID logoId;
}
