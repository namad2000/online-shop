package ir.shop.online.core.infrastructure.persistence.repository.jpa;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.repository.jpa.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJpaRepositoryAdapter implements ProductRepository {
    @Override
    public boolean existsByNameAndCategory(String title, Category category) {
        return false;
    }
}
