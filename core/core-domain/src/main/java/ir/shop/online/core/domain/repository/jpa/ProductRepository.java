package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.core.domain.model.category.Category;


public interface ProductRepository {

    boolean existsByNameAndCategory(String title, Category category);
}
