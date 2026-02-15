package ir.online.shop.infrastructure.persistence.mapper;

import io.qoop.jpa.persistence.mapper.CommonsInfrastructureMapper;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.domain.model.Vendor;
import ir.online.shop.infrastructure.persistence.entity.VendorEntity;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface VendorMapper extends CommonsInfrastructureMapper<Vendor, VendorEntity> {

    Vendor toDomain(VendorEntity vendorEntity);

    VendorEntity toEntity(Vendor vendor);

}
