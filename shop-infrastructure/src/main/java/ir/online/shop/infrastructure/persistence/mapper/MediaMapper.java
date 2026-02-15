package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.Media;
import ir.online.shop.infrastructure.persistence.entity.MediaEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface MediaMapper extends CommonsInfrastructureMapper<Media, MediaEntity> {

    Media  toDomain(MediaEntity entity);

    MediaEntity toEntity(Media domain);

}
