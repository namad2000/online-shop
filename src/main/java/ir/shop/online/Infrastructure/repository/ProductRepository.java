package ir.shop.online.Infrastructure.repository;


import ir.shop.online.domain.model.entity.Category;
import ir.shop.online.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByNameAndCategory(String title, Category category);
}
