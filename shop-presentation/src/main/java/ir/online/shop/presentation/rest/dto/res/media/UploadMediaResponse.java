package ir.online.shop.presentation.rest.dto.res.media;

import ir.online.shop.domain.model.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaResponse {

    private UUID id;
    private MediaType mediaType;
    private String url;
}
