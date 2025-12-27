package ir.shop.online.core.domain.service;

import ir.shop.online.commons.domain.annotation.DomainService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.NotNull;
import ir.shop.online.core.domain.exception.CategoryExceptionCode;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import lombok.RequiredArgsConstructor;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.shop.online.core.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category create(Category category) {

        Category parentCategory = null;

        // If a parent is specified, it must exist
        if (category.getParent() != null) {
            parentCategory = categoryRepository.findById(category.getParent().getId())
                    .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name()));
        } else {
            // If no parent is given but a root category already exists → not allowed
            boolean rootExists = categoryRepository.existsByParentIsNull();
            if (rootExists) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_03.name()); // Only one root category allowed
            }
        }

        if (parentCategory == null) {
            if (categoryRepository.existsByTitleAndParentIsNull(category.getTitle())) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_02.name()); // Duplicate category with same parent
            }
        } else {
            // Check if a category with the same title and parent already exists
            if (categoryRepository.existsByTitleAndParentId(category.getTitle(), parentCategory.getId())) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_02.name()); // Duplicate category with same parent
            }
        }

        // Determine the level
        int level = (parentCategory == null) ? 0 : parentCategory.getLevel() + 1;

        Category newCategory = buildCategory(category, parentCategory, level);

        return categoryRepository.save(newCategory);
    }

    public Category update(Category updatedCategory) {

        Category categoryFound = categoryRepository.findById(updatedCategory.getId())
                .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name()));

        boolean titleChanged = !categoryFound.getTitle().equals(updatedCategory.getTitle());

        if (titleChanged) {
            if (categoryFound.getParent() == null) {
                // Root categoryFound
                if (categoryRepository.existsByTitleAndParentIsNull(updatedCategory.getTitle())) {
                    throw new DomainException(CategoryExceptionCode.CATEGORY_02.name());
                }
            } else {
                // Child categoryFound
                if (categoryRepository.existsByTitleAndParentId(
                        updatedCategory.getTitle(),
                        categoryFound.getParent().getId()
                )) {
                    throw new DomainException(CategoryExceptionCode.CATEGORY_02.name());
                }
            }
        }

        categoryFound.setTitle(updatedCategory.getTitle());
        categoryFound.setDescription(updatedCategory.getDescription());
        categoryFound.setVersion(updatedCategory.getVersion());

        return categoryRepository.save(updatedCategory);
    }

    public Category getById(@NotNull Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name()));
    }

    private Category buildCategory(Category category, Category parentCategory, int level) {
        // Create a new category
        return Category.builder()
                .title(category.getTitle())
                .description(category.getDescription())
                .parent(parentCategory)
                .level(level)
                .build();
    }
}
