package ir.online.shop.application.model.result.media;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.domain.model.enums.MediaType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Data
@SuperBuilder
public class UploadMediaResult extends UpdateModel<UUID> {

    private MediaType mediaType;
    private String url;

}
