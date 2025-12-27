package ir.shop.online.core.presentation.rest.mapper;

import ir.shop.online.commons.mapper.CommonsMapperConfig;
import ir.shop.online.core.application.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.application.model.result.category.CategoryResult;
import ir.shop.online.core.presentation.rest.dto.req.category.CreateCategoryRequest;
import ir.shop.online.core.presentation.rest.dto.res.category.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper(config = CommonsMapperConfig.class)
public interface CategoryCommandMapper {

    CreateCategoryCmd toCommand(CreateCategoryRequest request);

    CategoryResponse toResponse(CategoryResult result);

}
