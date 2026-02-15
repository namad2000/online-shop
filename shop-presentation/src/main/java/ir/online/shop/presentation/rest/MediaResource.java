package ir.online.shop.presentation.rest;

import ir.online.shop.application.port.in.model.cmd.media.UploadMediaCmd;
import ir.online.shop.application.model.result.media.UploadMediaResult;
import ir.online.shop.application.port.in.usecase.UploadMediaUseCase;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.presentation.rest.dto.res.media.UploadMediaResponse;
import ir.online.shop.presentation.rest.mapper.UploadMediaCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static ir.online.shop.domain.model.enums.MediaType.IMAGE;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaResource {

    private final UploadMediaUseCase uploadMediaUseCase;
    private final UploadMediaCommandMapper uploadMediaCommandMapper;

    @PostMapping(
            value = "/upload/image/brand",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UploadMediaResponse uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "ownerType", required = false) MediaOwnerType ownerType,
            @RequestParam(value = "generateThumbnail", defaultValue = "false") boolean generateThumbnail,
            @RequestParam(value = "ownerId", required = false) UUID ownerId
    ) {
        UploadMediaCmd command = uploadMediaCommandMapper.toCommand(file, ownerType);
        UploadMediaResult mediaResult = uploadMediaUseCase.uploadMedia(command, IMAGE, ownerType, ownerId, generateThumbnail);
        return uploadMediaCommandMapper.toResponse(mediaResult);
    }

}
