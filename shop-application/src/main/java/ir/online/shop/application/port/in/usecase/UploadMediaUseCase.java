package ir.online.shop.application.port.in.usecase;

import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.mapper.api.shift.Shift;
import io.qoop.validation.api.IsValid;
import ir.online.shop.application.model.result.media.UploadMediaResult;
import ir.online.shop.application.port.in.mapper.UploadMediaMapper;
import ir.online.shop.application.port.in.model.cmd.media.UploadMediaCmd;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.domain.service.MediaService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class UploadMediaUseCase {

    private final MediaService mediaService; // Service responsible for file upload and storage
    private final UploadMediaMapper uploadMediaMapper;

    public UploadMediaResult uploadMedia(
            @IsValid UploadMediaCmd command,
            MediaType mediaType,
            MediaOwnerType ownerType,
            UUID ownerId,
            boolean generateThumbnail
    ) {
        // Call the service to upload the file and get the CDN URL
        Media media = mediaService.upload(uploadMediaMapper.toDomain(command), ownerType, ownerId, generateThumbnail);

        // Return the result containing the URL
        return Shift.just(media).toObject(UploadMediaResult.class);
    }
}
