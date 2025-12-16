package ir.shop.online.core.infrastructure.persistence.repository.jpa.spring;


import ir.shop.online.core.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {
    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, CategoryEntity parentCategory);
}
