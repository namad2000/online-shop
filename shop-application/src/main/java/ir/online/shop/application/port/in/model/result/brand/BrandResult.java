package ir.online.shop.application.port.in.model.result.brand;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
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
public class BrandResult extends UpdateModel<UUID> {

    private String name;
    private String description;
    private String slug;
    private String country;
    private MediaResult logo;
}
