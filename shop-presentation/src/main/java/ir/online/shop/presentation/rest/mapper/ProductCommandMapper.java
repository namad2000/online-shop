package ir.online.shop.presentation.rest.mapper;

import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.cmd.product.CreateProductCmd;
import ir.online.shop.application.port.in.model.result.product.ProductResult;
import ir.online.shop.presentation.rest.dto.req.product.CreateProductRequest;
import ir.online.shop.presentation.rest.dto.res.product.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface ProductCommandMapper {

    CreateProductCmd toCommand(CreateProductRequest request);

    ProductResponse toResponse(ProductResult result);

}
