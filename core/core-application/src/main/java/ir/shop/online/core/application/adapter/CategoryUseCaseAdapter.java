package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.NotNull;
import ir.shop.online.core.domain.exception.ExceptionCode;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class CategoryUseCaseAdapter implements CategoryUseCase {

    private final CategoryRepository categoryRepository;

    @IsValid
    @Override
    public Category getById(@NotNull Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_01.name()));
    }
}
