package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
import ir.online.shop.domain.model.Media;

@DomainMapper
public class MediaMapper implements/* InputMapper<CreateMediaCmd, Media>,*/ ResultMapper<Media, MediaResult> {

  /*  @Override
    public Media toDomain(CreateMediaCmd cmd, MappingContext context) {
        return Media.builder()
                .iname(cmd.getName())
                .description(cmd.getDescription())
                .country(cmd.getCountry())
                .build();
    }*/

    @Override
    public MediaResult toResult(Media domain, MappingContext context) {
        return domain == null ? null : MediaResult.builder()
                .id(domain.getId())
                .url(domain.getUrl())
                .mediaType(domain.getMediaType())
                .build();
    }
}
