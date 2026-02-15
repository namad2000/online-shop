package ir.online.shop.infrastructure.persistence.repository.jpa.spring;


import ir.online.shop.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, UUID> {
    boolean existsByParentIsNull();

    boolean existsByNameAndParentIsNull(String name);

    boolean existsByNameAndParent_Id(String name, UUID parentCategoryId);

    List<CategoryEntity> findAllByParent_Id(UUID parent_id);

    Page<CategoryEntity> findAllByNameContainingIgnoreCase(String name, PageRequest of);

    Page<CategoryEntity> findAllByIsActiveTrueAndIsDeletedFalse(PageRequest of);

    Page<CategoryEntity> findAllByNameContainingIgnoreCaseAndIsActiveTrueAndIsDeletedFalse(String name, PageRequest of);

    boolean existsBySlug(String slug);
}
