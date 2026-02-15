package ir.online.shop.presentation.rest.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.cmd.sale.CreateSaleProductCmd;
import ir.online.shop.application.port.in.model.result.sale.SaleProductResult;
import ir.online.shop.presentation.rest.dto.req.sale.CreateSaleProductRequest;
import ir.online.shop.presentation.rest.dto.res.sale.SaleProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonsMapperConfig.class)
public interface SaleProductCommandMapper {

    CreateSaleProductCmd toCommand(CreateSaleProductRequest request);

    SaleProductResponse toResponse(SaleProductResult result);

    List<SaleProductResponse> toResponse(List<SaleProductResult> result);

    PageData<SaleProductResponse> toResponse(PageData<SaleProductResult> result);
}
