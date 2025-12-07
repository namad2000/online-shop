package ir.shop.online.core.domain.repository;


import ir.shop.online.core.domain.model.Category;


public interface ProductRepository {

    boolean existsByNameAndCategory(String title, Category category);
}
