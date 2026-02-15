package ir.online.shop.presentation.rest.mapper;

import io.qoop.domain.model.PageData;
import io.qoop.mapper.core.CommonsMapperConfig;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.presentation.rest.dto.res.category.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CommonsMapperConfig.class)
public interface CategoryQueryMapper {

    // RESPONSE (Single)
    CategoryResponse toResponse(CategoryResult result);

    // RESPONSE (List)
    List<CategoryResponse> toResponseList(List<CategoryResult> results);

    // RESPONSE (Page)
    PageData<CategoryResponse> toResponseList(PageData<CategoryResult> results);
}
