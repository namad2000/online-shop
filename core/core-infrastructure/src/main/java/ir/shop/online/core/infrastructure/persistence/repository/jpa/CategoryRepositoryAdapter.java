package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import ir.shop.online.core.infrastructure.persistence.mapper.CategoryMapper;
import ir.shop.online.core.infrastructure.persistence.repository.jpa.spring.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public boolean existsByParentIsNull() {
        return categoryJpaRepository.existsByParentIsNull();
    }

    @Override
    public boolean existsByTitleAndParentIsNull(String title) {
        return categoryJpaRepository.existsByTitleAndParentIsNull(title);
    }

    @Override
    public boolean existsByTitleAndParentId(String title, Integer parentCategoryId) {
        return categoryJpaRepository.existsByTitleAndParent_Id(title, parentCategoryId);
    }

    @Override
    public Category save(@IsValid Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        categoryEntity = categoryJpaRepository.save(categoryEntity);

        return categoryMapper.toDomain(categoryEntity);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomainWithParent);
    }

    @Override
    public Boolean existById(Integer id) {
        return categoryJpaRepository.existsById(id);
    }
}
