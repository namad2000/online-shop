package ir.online.shop.domain.model;

import io.qoop.domain.model.UpdateModel;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaStatus;
import ir.online.shop.domain.model.enums.MediaType;
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
public class Media extends UpdateModel<UUID> {

    private String hash;

    private Long size;

    private String mimeType;

    private String url;

    private MediaType mediaType;

    private MediaStatus mediaStatus;

    private boolean main;

    private MediaOwnerType mediaOwnerType;

    private UUID ownerId;

    private boolean thumbnail;

    private Media parent;

}
