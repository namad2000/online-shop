package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.repository.jpa.BrandRepository;
import ir.online.shop.infrastructure.persistence.entity.BrandEntity;
import ir.online.shop.infrastructure.persistence.mapper.BrandMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.BrandJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryAdapter implements BrandRepository {

    private final BrandJpaRepository brandJpaRepository;
    private final BrandMapper brandMapper;

    @Override
    public boolean existsByName(String name) {
        return brandJpaRepository.existsByNameEqualsIgnoreCase(name);
    }

    @Override
    public Brand save(Brand brand) {
        BrandEntity brandEntity = brandMapper.toEntity(brand);
        brandEntity = brandJpaRepository.save(brandEntity);

        return brandMapper.toDomain(brandEntity);
    }

    @Override
    public Optional<Brand> findById(UUID id) {
        return brandJpaRepository.findById(id)
                .map(brandMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return brandJpaRepository.existsById(id);
    }

    @Override
    public PageData<Brand> findAll(Integer pageNumber, Integer pageSize) {
        Page<BrandEntity> all = brandJpaRepository.findAll(
                PageRequest.of(pageNumber, pageSize));
        return PageData.of(all.getTotalElements(), all.getTotalPages(), all.getContent().stream().map(brandMapper::toDomain).toList());

    }

    @Override
    public PageData<Brand> findAllByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize) {
        Page<BrandEntity> all = brandJpaRepository.findAllByNameContainingIgnoreCase(
                name, PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                all.getTotalElements(),
                all.getTotalPages(),
                all.getContent()
                        .stream().map(brandMapper::toDomain).toList());
    }

    @Override
    public Optional<Brand> findBySlug(String slug) {
        return brandJpaRepository.findBySlug(slug)
                .map(brandMapper::toDomain);
    }

    @Override
    public PageData<Brand> findAllActive(Integer pageNumber, Integer pageSize) {
        Page<BrandEntity> page = brandJpaRepository.findAllByIsActiveTrueAndIsDeletedFalse(
                PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent().stream().map(brandMapper::toDomain).toList()
        );
    }

    @Override
    public PageData<Brand> findAllActiveByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize) {
        Page<BrandEntity> page = brandJpaRepository.findAllByNameContainingIgnoreCaseAndIsActiveTrueAndIsDeletedFalse(
                name, PageRequest.of(pageNumber, pageSize));
        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent().stream().map(brandMapper::toDomain).toList()
        );
    }

    @Override
    public boolean existsBySlug(String slug) {
        return brandJpaRepository.existsBySlug(slug);
    }

    @Override
    public void delete(Brand domain, boolean logical) {
        BrandEntity entity = brandMapper.toEntity(domain);
        if (logical) {
            entity.setIsDeleted(Boolean.TRUE);
            brandJpaRepository.save(entity);
        } else {
            brandJpaRepository.delete(entity);
        }
    }
}
