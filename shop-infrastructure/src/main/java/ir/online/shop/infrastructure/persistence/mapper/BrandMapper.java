package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.infrastructure.persistence.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(config = CommonsMapperConfig.class)
public interface BrandMapper extends CommonsInfrastructureMapper<Brand, BrandEntity> {
    Brand toDomain(BrandEntity entity);

    PageData<Brand> toDomain(Page<BrandEntity> entity);

    BrandEntity toEntity(Brand domain);

}
