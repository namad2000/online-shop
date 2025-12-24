package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@ApplicationScoped
public class CategoryRepositoryAdapter implements CategoryRepository {

//    @Inject
//    CategoryMapper categoryMapper;


    @PersistenceContext
    EntityManager em;

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
        CategoryEntity categoryFound = em.find(CategoryEntity.class, id);

        return Optional.of(
                Category.builder()
                        .id(categoryFound.getId())
                        .title(categoryFound.getTitle())
                        .description(categoryFound.getDescription())
                        .build()
        );
    }

    @Override
    public Boolean existById(Integer id) {
        return false;
    }
}
