package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.commons.infrastructure.repository.JpaRepository;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepositoryJpaAdapter extends JpaRepository<Category, Integer> implements CategoryRepository {

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
