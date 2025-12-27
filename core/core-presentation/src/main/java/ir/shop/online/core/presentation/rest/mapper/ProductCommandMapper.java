package ir.shop.online.core.presentation.rest.mapper;

import ir.shop.online.commons.mapper.CommonsMapperConfig;
import ir.shop.online.core.domain.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.domain.model.result.product.ProductResult;
import ir.shop.online.core.presentation.rest.dto.req.product.CreateProductRequest;
import ir.shop.online.core.presentation.rest.dto.res.product.CreateProductResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface ProductCommandMapper {

    CreateProductCmd toCommand(CreateProductRequest request);

    CreateProductResponse toResponse(ProductResult result);

}
