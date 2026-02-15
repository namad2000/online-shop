package ir.online.shop.presentation.rest.dto.res.media;

import ir.online.shop.domain.model.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaResponse {

//    private Long id;

    private MediaType mediaType;

    private String url;

//    private boolean main;
}
