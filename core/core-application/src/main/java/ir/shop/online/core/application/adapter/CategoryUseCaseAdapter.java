package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.commons.domain.validation.NotNull;
import ir.shop.online.core.application.mapper.CategoryInternalMapper;
import ir.shop.online.core.domain.exception.CategoryExceptionCode;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.domain.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.domain.model.result.category.CategoryResult;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class CategoryUseCaseAdapter implements CategoryUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryInternalMapper categoryInternalMapper;

//    @Property(key = "test", defaultValue = "3000")
//    private int test;

    @IsValid
    @Override
    public CategoryResult create(CreateCategoryCmd createCategoryCmd) {

        Category parentCategory = null;

        // If a parent is specified, it must exist
        if (createCategoryCmd.getParentId() != null) {
            parentCategory = categoryRepository.findById(createCategoryCmd.getParentId())
                    .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name()));
        } else {
            // If no parent is given but a root category already exists → not allowed
            boolean rootExists = categoryRepository.existsByParentIsNull();
            if (rootExists) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_03.name()); // Only one root category allowed
            }
        }

        if (parentCategory == null) {
            if (categoryRepository.existsByTitleAndParentIsNull(createCategoryCmd.getTitle())) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_02.name()); // Duplicate category with same parent
            }
        } else {
            // Check if a category with the same title and parent already exists
            if (categoryRepository.existsByTitleAndParentId(createCategoryCmd.getTitle(), parentCategory.getId())) {
                throw new DomainException(CategoryExceptionCode.CATEGORY_02.name()); // Duplicate category with same parent
            }
        }

        // Determine the level
        int level = (parentCategory == null) ? 0 : parentCategory.getLevel() + 1;

        Category newCategory = buildCategory(createCategoryCmd, parentCategory, level);

        Category save = categoryRepository.save(newCategory);
        return categoryInternalMapper.map(save);
    }

    @IsValid
    @Override
    public CategoryResult update(Integer id, UpdateCategoryCmd command) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name()));

        boolean titleChanged = !category.getTitle().equals(command.getTitle());

        if (titleChanged) {
            if (category.getParent() == null) {
                // Root category
                if (categoryRepository.existsByTitleAndParentIsNull(command.getTitle())) {
                    throw new DomainException(CategoryExceptionCode.CATEGORY_02.name());
                }
            } else {
                // Child category
                if (categoryRepository.existsByTitleAndParentId(
                        command.getTitle(),
                        category.getParent().getId()
                )) {
                    throw new DomainException(CategoryExceptionCode.CATEGORY_02.name());
                }
            }
        }

        category.setTitle(command.getTitle());
        category.setDescription(command.getDescription());

        return categoryInternalMapper.map(categoryRepository.save(category));
    }

    @IsValid
    @Override
    public CategoryResult getById(@NotNull Integer categoryId) {
        return categoryInternalMapper.map(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DomainException(CategoryExceptionCode.CATEGORY_01.name())));
    }

    private static Category buildCategory(CreateCategoryCmd createCategoryCmd, Category parentCategory, int level) {
        // Create a new category
        return Category.builder()
                .title(createCategoryCmd.getTitle())
                .description(createCategoryCmd.getDescription())
                .parent(parentCategory)
                .level(level)
                .build();
    }
}
