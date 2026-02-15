package ir.online.shop.presentation.rest.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
import ir.online.shop.presentation.rest.dto.res.media.MediaResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface MediaCommandMapper {
    MediaResponse toResponse(MediaResult result);

}
