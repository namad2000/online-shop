package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.commons.infrastructure.persistence.repository.JpaRepositoryAdapter;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import ir.shop.online.core.infrastructure.persistence.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryJpaRepositoryAdapter extends JpaRepositoryAdapter<Category, CategoryEntity, Integer, CategoryMapper>
        implements CategoryRepository<CategoryEntity> {

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByParentIsNull() {
        return false;
    }

    @Override
    public boolean existsByTitleAndParent(String title, Category parentCategory) {
        return false;
    }
}
