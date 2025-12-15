package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.commons.domain.repository.JpaRepository;
import ir.shop.online.core.domain.model.category.Category;

import java.util.Optional;

public interface CategoryRepository<E> extends JpaRepository<Category, Integer> {

    Optional<Category> findById(Integer id);

    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, Category parentCategory);
}
