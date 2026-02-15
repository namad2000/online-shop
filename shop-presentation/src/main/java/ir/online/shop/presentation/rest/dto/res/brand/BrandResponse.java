package ir.online.shop.presentation.rest.dto.res.brand;

import ir.online.shop.presentation.rest.dto.res.media.MediaResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BrandResponse {

    private UUID id;
    private String name;
    private String description;
    private String country;
    private String slug;
    private MediaResponse logo;
}
