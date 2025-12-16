package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.exception.ExceptionCode;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.CreateCategory;
import ir.shop.online.core.domain.model.category.UpdateCategory;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@UseCaseService
@RequiredArgsConstructor
public class CategoryUseCaseAdapter implements CategoryUseCase {

    private final CategoryRepository categoryRepository;


    @IsValid
    @Override
    @SneakyThrows
    public Category create(CreateCategory createCategory) {

        Category parentCategory = null;

        // If a parent is specified, it must exist
        if (createCategory.getParentId() != null) {
            parentCategory = categoryRepository.findById(createCategory.getParentId())
                    .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_03.name()));
        } else {
            // If no parent is given but a root category already exists → not allowed
            boolean rootExists = categoryRepository.existsByParentIsNull();
            if (rootExists) {
                throw new DomainException(ExceptionCode.CATEGORY_04.name()); // Only one root category allowed
            }
        }

        // Check if a category with the same title and parent already exists
        if (categoryRepository.existsByTitleAndParent(createCategory.getTitle(), parentCategory)) {
            throw new DomainException(ExceptionCode.CATEGORY_01.name()); // Duplicate category with same parent
        }

        // Determine the level
        int level = (parentCategory == null) ? 0 : parentCategory.getLevel() + 1;

        Category newCategory = buildCategory(createCategory, parentCategory, level);

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category update(UpdateCategory updateCategory) {

        Category parentCategoryFound = categoryRepository.findById(updateCategory.getParentId())
                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_02.name()));
        Category categoryFound = categoryRepository.findById(updateCategory.getId())
                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_02.name()));


        Category.builder()
                .id(updateCategory.getId())
                .title(updateCategory.getTitle())
                .description(updateCategory.getDescription())
                .parent(updateCategory.)
                .level(level)
                .build();

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getById(Integer categoryId) {
//        return categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_02.name()));
        return null;
    }

    private static Category buildCategory(CreateCategory createCategory, Category parentCategory, int level) {
        // Create a new category
        return Category.builder()
                .title(createCategory.getTitle())
                .description(createCategory.getDescription())
                .parent(parentCategory)
                .level(level)
                .build();
    }
}
