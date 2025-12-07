package ir.shop.online.Infrastructure.repository;


import ir.shop.online.domain.model.entity.Category;
import ir.shop.online.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByParentIsNull();

    boolean existsByTitleAndParent(String title, Category parentCategory);
}
