package ir.online.shop.presentation.rest.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.result.brand.BrandComboResult;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.presentation.rest.dto.res.brand.BrandComboResponse;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonsMapperConfig.class)
public interface BrandQueryMapper {

    // RESPONSE (Single)
    BrandResponse toResponse(BrandResult result);

    // RESPONSE (List)
    List<BrandResponse> toResponseList(List<BrandResult> results);

    // RESPONSE (Page)
    PageData<BrandResponse> toResponseList(PageData<BrandResult> results);

    PageData<BrandComboResponse> toResponseComboList(PageData<BrandComboResult> results);
}
