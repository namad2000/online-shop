package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.infrastructure.persistence.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryMapper categoryMapper;

    @Override
    public boolean existsByParentIsNull() {
        return false;
    }

    @Override
    public boolean existsByTitleAndParentIsNull(String title) {
        return false;
    }

    @Override
    public boolean existsByTitleAndParentId(String title, Integer parentCategoryId) {
        return false;
    }

    @Override
    public Category save(@IsValid Category category) {
        return null;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.ofNullable(Category.builder()
                .title("برای کواکوس")
                .description("تست برای مهندس سلطانی عزیز")
                .build()
        );
    }

    @Override
    public Boolean existById(Integer id) {
        return false;
    }
}
