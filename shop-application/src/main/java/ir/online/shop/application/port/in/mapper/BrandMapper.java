package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.brand.CreateBrandCmd;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.domain.model.Brand;

@DomainMapper
public class BrandMapper implements InputMapper<CreateBrandCmd, Brand>, ResultMapper<Brand, BrandResult> {

    @Override
    public Brand toDomain(CreateBrandCmd cmd, MappingContext context) {
        return Brand.builder()
                .name(cmd.getName())
                .description(cmd.getDescription())
                .country(cmd.getCountry())
                .slug(cmd.getSlug())
                .build();
    }

    @Override
    public BrandResult toResult(Brand domain, MappingContext context) {
        return domain == null ? null : BrandResult.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .slug(domain.getSlug())
                .country(domain.getCountry())
                .build();
    }
}
