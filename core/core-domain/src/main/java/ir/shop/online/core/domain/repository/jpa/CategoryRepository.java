package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.commons.domain.repository.DomainRepository;
import ir.shop.online.core.domain.model.category.Category;

public interface CategoryRepository extends DomainRepository<Category, Integer> {

    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, Category parentCategory);
}
