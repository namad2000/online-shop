package ir.shop.online.core.infrastructure.persistence.repository;


import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryJpaAdapter implements CategoryRepository {

    @Override
    public boolean existsByParentIsNull() {
        return false;
    }

    @Override
    public boolean existsByTitleAndParent(String title, Category parentCategory) {
        return false;
    }
}
