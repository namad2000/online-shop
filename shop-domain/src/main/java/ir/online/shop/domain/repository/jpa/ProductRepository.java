package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Product;

import java.util.UUID;


public interface ProductRepository extends DomainRepository<Product, UUID> {

    boolean existsByNameAndCategory(String name, Category category);

    boolean existsBySku(String sku);
}
