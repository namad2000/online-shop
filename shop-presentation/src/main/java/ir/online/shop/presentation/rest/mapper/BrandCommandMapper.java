package ir.online.shop.presentation.rest.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.cmd.brand.CreateBrandCmd;
import ir.online.shop.application.port.in.model.cmd.brand.UpdateBrandCmd;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.presentation.rest.dto.req.brand.CreateBrandRequest;
import ir.online.shop.presentation.rest.dto.req.brand.UpdateBrandRequest;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(config = CommonsMapperConfig.class)
public interface BrandCommandMapper {

    // CREATE
    CreateBrandCmd toCommand(CreateBrandRequest request);

    // UPDATE
    @Mapping(target = "id", source = "id")
    UpdateBrandCmd toCommand(UUID id, UpdateBrandRequest request);

    // RESPONSE
    BrandResponse toResponse(BrandResult result);

    List<BrandResponse> toResponseList(List<BrandResult> results);

    PageData<BrandResponse> toResponseList(PageData<BrandResult> results);
}
