package ir.online.shop.domain.model.validator;

import io.qoop.fault.handler.api.exception.DomainBusinessException;
import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.repository.jpa.BrandRepository;

import static ir.online.shop.domain.exception.BrandExceptionCode.BRAND_IS_DUPLICATE;

@DomainService
public record BrandValidator(BrandRepository brandRepository) {

    /**
     * Check if brand name is unique.
     */
    public void validateNameUnique(String name) {
        if (brandRepository.existsByName(name)) {
            throw DomainBusinessException.withParams(BRAND_IS_DUPLICATE, name);
        }
    }

    /**
     * Check if name is unique when renamed.
     */
    public void validateNameUniqueWhenRenamed(Brand existing, String newName) {
        // Business Rule: name uniqueness (except itself)
        if (!existing.getName().equals(newName)
                && brandRepository.existsByName(newName)) {
            throw DomainException.withParams(BRAND_IS_DUPLICATE, newName);
        }
    }
}
