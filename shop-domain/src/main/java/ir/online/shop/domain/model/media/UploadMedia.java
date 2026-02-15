package ir.online.shop.domain.model.media;

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
public class UploadMedia {

    private MediaOwnerType ownerType;

    private byte[] bytes;

    private String originalFilename;

    private String contentType;

    private long size;

    private InputStream inputStream;
}
