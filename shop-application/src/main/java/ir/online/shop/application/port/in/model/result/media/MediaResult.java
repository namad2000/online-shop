package ir.online.shop.application.port.in.model.result.media;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Data
@SuperBuilder
public class MediaResult extends UpdateModel<UUID> {

    private MediaType mediaType;
    private MediaOwnerType mediaOwnerType;
    private boolean main;
    private boolean thumbnail;
    private UUID parentId;
    private String url;

}
