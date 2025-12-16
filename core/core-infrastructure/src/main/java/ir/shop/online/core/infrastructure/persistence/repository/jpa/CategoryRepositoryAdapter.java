package ir.shop.online.core.infrastructure.persistence.repository.jpa;


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
    public boolean existsByTitleAndParent(String title, Category parentCategory) {
        CategoryEntity parentCategoryEntity = categoryMapper.toEntity(parentCategory);
        return categoryJpaRepository.existsByTitleAndParent(title, parentCategoryEntity);
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        categoryEntity = categoryJpaRepository.save(categoryEntity);

        return categoryMapper.toDomain(categoryEntity);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomain);
    }

    @Override
    public Boolean existById(Integer id) {
        return categoryJpaRepository.existsById(id);
    }
}
