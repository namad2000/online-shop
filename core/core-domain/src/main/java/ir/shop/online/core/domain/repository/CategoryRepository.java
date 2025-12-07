package ir.shop.online.core.domain.repository;


import ir.shop.online.core.domain.model.Category;

public interface CategoryRepository {

    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, Category parentCategory);
}
