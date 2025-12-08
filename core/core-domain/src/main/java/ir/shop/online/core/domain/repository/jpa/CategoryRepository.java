package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.core.domain.model.category.Category;

import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Integer id);

    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, Category parentCategory);
}
