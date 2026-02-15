package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.model.PageData;
import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends DomainRepository<Category, UUID> {

    boolean existsByParentIsNull();
    boolean existsByNameAndParentIsNull(String name);
    boolean existsByNameAndParentId(String name, UUID parentCategoryId);
    PageData<Category> findAllActive(Integer pageNumber, Integer pageSize);
    List<Category> getChildrenByParentId(UUID parentId);
    PageData<Category> findAllByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize);
    PageData<Category> findAllActiveByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize);
    boolean existsBySlug(String slug);
}
