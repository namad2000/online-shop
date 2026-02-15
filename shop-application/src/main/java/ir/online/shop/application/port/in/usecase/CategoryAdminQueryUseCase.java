package ir.online.shop.application.port.in.usecase;

import io.qoop.domain.model.PageData;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.transaction.api.DomainTransaction;
import io.qoop.validation.api.IsValid;
import io.qoop.validation.api.NotNull;
import ir.online.shop.application.port.in.mapper.CategoryInternalMapper;
import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.domain.service.CategoryService;
import ir.online.shop.domain.service.MediaService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class CategoryAdminQueryUseCase {

    private final CategoryService categoryService;
    private final CategoryInternalMapper categoryMapper;
    private final MediaService mediaService;

    // ---------- CREATE ----------
    @DomainTransaction
    public UUID create(@IsValid CreateCategoryCmd command) {

        Category parent = command.getParentId() == null ? null : categoryService.getById(command.getParentId());
        Category category = categoryMapper.toDomain(command);
        Category savedCategory = categoryService.create(category, parent);

        if (command.getMediaId() != null) {
            Media media = mediaService.getMedia(command.getMediaId(), MediaType.IMAGE, MediaOwnerType.CATEGORY);
            if (media != null) {
                mediaService.assignAndUpdate(media, savedCategory.getId(), true);
            }
        }

        return savedCategory.getId();
    }

    // ---------- UPDATE ----------
    @DomainTransaction
    public CategoryResult update(@NotNull UpdateCategoryCmd command) {
        Category category = categoryMapper.toDomain(command);
        Category updatedCategory = categoryService.update(category);
        return categoryMapper.toResult(updatedCategory);
    }

    // ---------- GET BY ID ----------
    public CategoryResult getById(@NotNull UUID id) {
        Category category = categoryService.getById(id);
        return categoryMapper.toResult(category);
    }

    // ---------- GET ALL ----------
    public PageData<CategoryResult> getAll(Integer pageNumber, Integer pageSize) {
        PageData<Category> all = categoryService.getAll(pageNumber, pageSize);

        List<CategoryResult> results = all.getContents().stream()
                .map(categoryMapper::toResult)
                .toList();

        return PageData.of(all.getTotalElements(), all.getTotalPages(), results);
    }

    // ---------- DELETE ----------
    @DomainTransaction
    public void delete(@NotNull UUID id) {
        categoryService.delete(id);
    }

    // ---------- ACTIVATE / DEACTIVATE ----------
    @DomainTransaction
    public void activate(@NotNull UUID id) {
        categoryService.activate(id);
    }

    @DomainTransaction
    public void deactivate(@NotNull UUID id) {
        categoryService.deactivate(id);
    }
}
