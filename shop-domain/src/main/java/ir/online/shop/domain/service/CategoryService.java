package ir.online.shop.domain.service;

import io.qoop.utils.api.StringUtil;
import io.qoop.domain.model.PageData;
import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import io.qoop.utils.api.SlugUtil;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.validator.CategoryValidator;
import ir.online.shop.domain.repository.jpa.CategoryRepository;

import java.util.List;
import java.util.UUID;

import static ir.online.shop.domain.exception.CategoryExceptionCode.*;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.online.shop.domain.service
 */

@DomainService
public record CategoryService(CategoryRepository categoryRepository, CategoryValidator categoryValidator) {

    public Category create(Category category, Category parent) {

        categoryValidator.validateNameUniqueAndParent(category.getName(), parent);

        category.setSlug(generateUniqueCategorySlug(category));

        Category newCategory = buildCategory(category, parent);

        return categoryRepository.save(newCategory);
    }

    public Category update(Category updatedCategory) {

        Category categoryFound = categoryRepository.findById(updatedCategory.getId())
                .orElseThrow(() -> DomainException.of(CATEGORY_NOT_FOUND));

        boolean titleChanged = !categoryFound.getName().equals(updatedCategory.getName());

        if (titleChanged) {
            if (categoryFound.getParent() == null) {
                // Root categoryFound
                if (categoryRepository.existsByNameAndParentIsNull(updatedCategory.getName())) {
                    throw DomainException.of(CATEGORY_IS_DUPLICATE);
                }
            } else {
                // Child categoryFound
                if (categoryRepository.existsByNameAndParentId(
                        updatedCategory.getName(),
                        categoryFound.getParent().getId()
                )) {
                    throw DomainException.of(CATEGORY_IS_DUPLICATE);
                }
            }
        }

        categoryFound.setName(updatedCategory.getName());
        categoryFound.setDescription(updatedCategory.getDescription());
        categoryFound.setVersion(updatedCategory.getVersion());

        return categoryRepository.save(updatedCategory);
    }

    public Category getById(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> DomainException.of(CATEGORY_NOT_FOUND));
    }

    // ---------- GET ALL ----------
    public PageData<Category> getAll(Integer pageNumber, Integer pageSize) {
        return categoryRepository.findAll(pageNumber, pageSize);
    }

    // ---------- SEARCH BY NAME ----------
    public PageData<Category> search(String name, Integer pageNumber, Integer pageSize) {
        return categoryRepository.findAllByNameContainingIgnoreCase(name, pageNumber, pageSize);
    }

    // ---------- SEARCH ACTIVE ----------
    public PageData<Category> searchActive(String name, Integer pageNumber, Integer pageSize) {
        return categoryRepository.findAllActiveByNameContainingIgnoreCase(name, pageNumber, pageSize);
    }

    public List<Category> getChildrenByParentId(UUID parentId) {
        return categoryRepository.getChildrenByParentId(parentId);
    }

    public PageData<Category> getAllActive(Integer pageNumber, Integer pageSize) {
        return categoryRepository.findAll(pageNumber, pageSize);
    }

    public void delete(UUID id) {

    }

    public void activate(UUID id) {
        changeBrandActivate(id, true);
    }

    public void deactivate(UUID id) {
        changeBrandActivate(id, false);
    }

    private String generateUniqueCategorySlug(Category category) {
        String categorySlug = StringUtil.isEmpty(category.getSlug()) ? category.getName() : category.getSlug();

        String baseSlug = SlugUtil.toSlug(categorySlug);
        String slug = baseSlug;
        int counter = 1;

        while (categoryRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter;
            counter++;
        }

        return slug;
    }

    private Category buildCategory(Category category, Category parentCategory) {
        // Create a new category
        return Category.builder()
                .name(category.getName())
                .description(category.getDescription())
                .slug(category.getSlug())
                .parent(parentCategory)
                .build();
    }

    private void changeBrandActivate(UUID id, boolean active) {
        Category category = getById(id);
        category.setActive(active);
        update(category);
    }
}
