package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.repository.jpa.CategoryRepository;
import ir.online.shop.infrastructure.persistence.entity.CategoryEntity;
import ir.online.shop.infrastructure.persistence.mapper.CategoryMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public boolean existsByParentIsNull() {
        return categoryJpaRepository.existsByParentIsNull();
    }

    @Override
    public boolean existsByNameAndParentIsNull(String name) {
        return categoryJpaRepository.existsByNameAndParentIsNull(name);
    }

    @Override
    public boolean existsByNameAndParentId(String name, UUID parentCategoryId) {
        return categoryJpaRepository.existsByNameAndParent_Id(name, parentCategoryId);
    }

    @Override
    public PageData<Category> findAllActive(Integer pageNumber, Integer pageSize) {
        Page<CategoryEntity> page = categoryJpaRepository.findAllByIsActiveTrueAndIsDeletedFalse(
                PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent().stream().map(categoryMapper::toDomain).toList()
        );
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        categoryEntity = categoryJpaRepository.save(categoryEntity);

        return categoryMapper.toDomain(categoryEntity);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomainWithParent);
    }

    @Override
    public Boolean existById(UUID id) {
        return categoryJpaRepository.existsById(id);
    }

    @Override
    public PageData<Category> findAll(Integer pageNumber, Integer pageSize) {
        Page<CategoryEntity> all = categoryJpaRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                all.getTotalElements(),
                all.getTotalPages(),
                all.getContent().stream()
                        .map(categoryMapper::toDomain).toList());
    }

    @Override
    public void delete(Category domain, boolean logical) {

    }

    @Override
    public List<Category> getChildrenByParentId(UUID parentId) {
        return categoryJpaRepository.findAllByParent_Id(parentId).stream()
                .map(categoryMapper::toDomainWithParentAndChildren).toList();
    }

    @Override
    public PageData<Category> findAllByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize) {
        Page<CategoryEntity> all = categoryJpaRepository.findAllByNameContainingIgnoreCase(
                name, org.springframework.data.domain.PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                all.getTotalElements(),
                all.getTotalPages(),
                all.getContent().stream()
                        .map(categoryMapper::toDomain).toList());
    }

    @Override
    public PageData<Category> findAllActiveByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize) {
        Page<CategoryEntity> page = categoryJpaRepository.findAllByNameContainingIgnoreCaseAndIsActiveTrueAndIsDeletedFalse(
                name, PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent().stream().map(categoryMapper::toDomain).toList()
        );
    }

    @Override
    public boolean existsBySlug(String slug) {
        return categoryJpaRepository.existsBySlug(slug);
    }
}
