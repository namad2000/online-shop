package ir.online.shop.presentation.rest.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.model.result.media.UploadMediaResult;
import ir.online.shop.application.port.in.model.cmd.media.UploadMediaCmd;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.presentation.rest.dto.res.media.UploadMediaResponse;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(config = CommonsMapperConfig.class)
public interface UploadMediaCommandMapper {

    default UploadMediaCmd toCommand(MultipartFile file, MediaOwnerType ownerType) {
        try {
            return UploadMediaCmd.builder()
                    .ownerType(ownerType)
                    .bytes(file.getBytes())
                    .originalFilename(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .inputStream(file.getInputStream())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read multipart file", e);
        }
    }

    UploadMediaResponse toResponse(UploadMediaResult result);

}
