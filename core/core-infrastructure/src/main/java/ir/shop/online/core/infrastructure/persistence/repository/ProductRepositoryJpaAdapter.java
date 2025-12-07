package ir.shop.online.core.infrastructure.persistence.repository;


import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryJpaAdapter implements ProductRepository {
    @Override
    public boolean existsByNameAndCategory(String title, Category category) {
        return false;
    }
}
