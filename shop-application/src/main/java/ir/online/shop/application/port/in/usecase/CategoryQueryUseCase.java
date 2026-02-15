package ir.online.shop.application.port.in.usecase;

import io.qoop.domain.model.PageData;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.validation.api.NotNull;
import ir.online.shop.application.port.in.mapper.CategoryInternalMapper;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class CategoryQueryUseCase {

    private final CategoryService categoryService;
    private final CategoryInternalMapper categoryInternalMapper;

    // ---------- GET ALL ACTIVE ----------
    public PageData<CategoryResult> getActiveCategories(
            Integer pageNumber, Integer pageSize
    ) {
        PageData<Category> page = categoryService.getAllActive(pageNumber, pageSize);

        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                categoryInternalMapper.toResultList(page.getContents())
        );
    }

    // ---------- SEARCH ACTIVE ----------
    public PageData<CategoryResult> searchActive(
            @NotNull String name,
            Integer pageNumber, Integer pageSize
    ) {
        PageData<Category> page =
                categoryService.searchActive(name, pageNumber, pageSize);

        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                categoryInternalMapper.toResultList(page.getContents())
        );
    }
}
