package ir.online.shop.application.port.in.model.cmd.media;

import io.qoop.validation.api.Max;
import io.qoop.validation.api.NotEmpty;
import io.qoop.validation.api.NotNull;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaCmd {

    @NotNull
    private MediaOwnerType ownerType;

    @NotNull
    private byte[] bytes;

    @NotEmpty
    private String originalFilename;

    @NotEmpty
    private String contentType;

    @Max(50000)
    private long size;

    @NotNull
    private InputStream inputStream;

}
