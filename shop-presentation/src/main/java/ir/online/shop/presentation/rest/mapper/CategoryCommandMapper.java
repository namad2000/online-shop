package ir.online.shop.presentation.rest.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.presentation.rest.dto.req.category.CreateCategoryRequest;
import ir.online.shop.presentation.rest.dto.res.category.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = CommonsMapperConfig.class)
public interface CategoryCommandMapper {

    CreateCategoryCmd toCommand(CreateCategoryRequest request);

    @Mapping(target = "children", ignore = true)
    CategoryResponse toResponse(CategoryResult result);

    List<CategoryResponse> toResponseList(List<CategoryResult> results);

    PageData<CategoryResponse> toResponseList(PageData<CategoryResult> results);
}
