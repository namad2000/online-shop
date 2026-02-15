package ir.online.shop.domain.model.validator;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.repository.jpa.CategoryRepository;

import static ir.online.shop.domain.exception.CategoryExceptionCode.CATEGORY_IS_DUPLICATE;
import static ir.online.shop.domain.exception.CategoryExceptionCode.ONLY_ONE_CATEGORY_CAN_EXIST_WITHOUT_PARENT;

@DomainService
public record CategoryValidator(CategoryRepository categoryRepository) {

    /**
     * Check if category name is unique and only 1 parent can exist in system.
     */
    public void validateNameUniqueAndParent(String name, Category parent) {
        // Rule 1: Only one root category is allowed
        if (parent == null) {
            if (categoryRepository.existsByParentIsNull()) {
                throw DomainException.of(ONLY_ONE_CATEGORY_CAN_EXIST_WITHOUT_PARENT);
            }
        }
        // Rule 2: Category name must be unique under the same parent
        else {
            if (categoryRepository.existsByNameAndParentId(name, parent.getId())) {
                throw DomainException.of(CATEGORY_IS_DUPLICATE);
            }
        }
    }

    /**
     * Check if name is unique when renamed.
     */
    public void validateNameUniqueWhenRenamed(Category parent, Category existing, String newName) {
        if (parent != null) {
            // Business Rule: name uniqueness (except itself)
            if (!existing.getName().equals(newName)
                    && categoryRepository.existsByNameAndParentId(newName, parent.getId())) {
                throw DomainException.withParams(CATEGORY_IS_DUPLICATE, newName);
            }
        }
    }

}
