package ir.online.shop.infrastructure.persistence.repository.jpa.spring;

import ir.online.shop.infrastructure.persistence.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BrandJpaRepository extends JpaRepository<BrandEntity, UUID> {

    // ---------- CHECK NAME ----------
    boolean existsByNameEqualsIgnoreCase(String name);

    // ---------- FIND BY ID / NAME ----------
    Page<BrandEntity> findAllByNameContainingIgnoreCase(String name, PageRequest pageRequest);

    // ---------- FIND BY SLUG ----------
    Optional<BrandEntity> findBySlug(String slug);

    // ---------- FIND ALL ACTIVE ----------
    Page<BrandEntity> findAllByIsActiveTrueAndIsDeletedFalse(PageRequest pageRequest);

    // ---------- FIND ACTIVE BY NAME ----------
    Page<BrandEntity> findAllByNameContainingIgnoreCaseAndIsActiveTrueAndIsDeletedFalse(
            String name, PageRequest pageRequest
    );

    boolean existsBySlug(String slug);
}
