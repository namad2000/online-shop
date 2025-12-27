package ir.shop.online.core.domain.repository.jpa;


import ir.shop.online.commons.domain.repository.DomainRepository;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.Product;


public interface ProductRepository extends DomainRepository<Product, Long> {

    boolean existsByNameAndCategory(String title, Category category);

    boolean existsBySku(String sku);
}
