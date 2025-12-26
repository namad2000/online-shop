package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.commons.domain.repository.DomainRepository;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.product.Product;


public interface ProductRepository extends DomainRepository<Product, Long> {

    boolean existsByNameAndCategory(String title, Category category);
}
