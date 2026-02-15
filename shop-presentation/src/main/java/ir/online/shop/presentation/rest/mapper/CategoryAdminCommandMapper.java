package ir.online.shop.presentation.rest.mapper;

import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.presentation.rest.dto.req.category.CreateCategoryRequest;
import ir.online.shop.presentation.rest.dto.req.category.UpdateCategoryRequest;
import ir.online.shop.presentation.rest.dto.res.category.CategoryAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CategoryAdminCommandMapper {

    // ---------- CREATE ----------
    CreateCategoryCmd toCommand(CreateCategoryRequest request);

    // ---------- UPDATE ----------
    @Mapping(target = "id", source = "id")
    UpdateCategoryCmd toCommand(UUID id, UpdateCategoryRequest request);

    // ---------- RESPONSE ----------
    @Mapping(target = "children", ignore = true)
    // برای کنترل maxDepth، در UseCase ساخته می‌شود
    CategoryAdminResponse toResponse(CategoryResult result, int maxDepth);

//    List<CategoryAdminResponse> toResponseList(List<CategoryResult> results, int maxDepth);
}
