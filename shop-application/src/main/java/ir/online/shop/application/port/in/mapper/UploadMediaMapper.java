package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import ir.online.shop.application.port.in.model.cmd.media.UploadMediaCmd;
import ir.online.shop.domain.model.media.UploadMedia;
import lombok.RequiredArgsConstructor;

@DomainMapper
@RequiredArgsConstructor
public class UploadMediaMapper implements InputMapper<UploadMediaCmd, UploadMedia> {

    private final ProductMapper productMapper;

    @Override
    public UploadMedia toDomain(UploadMediaCmd cmd, MappingContext context) {
        return UploadMedia.builder()
                .bytes(cmd.getBytes())
                .contentType(cmd.getContentType())
                .size(cmd.getSize())
                .inputStream(cmd.getInputStream())
                .ownerType(cmd.getOwnerType())
                .originalFilename(cmd.getOriginalFilename())
                .build();
    }

}
