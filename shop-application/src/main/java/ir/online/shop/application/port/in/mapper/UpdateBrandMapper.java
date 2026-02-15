package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import ir.online.shop.application.port.in.model.cmd.brand.UpdateBrandCmd;
import ir.online.shop.domain.model.Brand;

@DomainMapper
public class UpdateBrandMapper implements InputMapper<UpdateBrandCmd, Brand> {

    @Override
    public Brand toDomain(UpdateBrandCmd cmd, MappingContext context) {
        return Brand.builder()
                .id(cmd.getId())
                .name(cmd.getName())
                .description(cmd.getDescription())
                .country(cmd.getCountry())
                .version(cmd.getVersion())
                .build();
    }
}
