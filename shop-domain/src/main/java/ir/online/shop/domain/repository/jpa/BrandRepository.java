package ir.online.shop.domain.repository.jpa;


import io.qoop.domain.model.PageData;
import io.qoop.domain.repository.DomainRepository;
import ir.online.shop.domain.model.Brand;

import java.util.Optional;
import java.util.UUID;

public interface BrandRepository extends DomainRepository<Brand, UUID> {
    boolean existsByName(String name);

    PageData<Brand> findAllByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize);

    Optional<Brand> findBySlug(String slug);

    PageData<Brand> findAllActive(Integer pageNumber, Integer pageSize);

    PageData<Brand> findAllActiveByNameContainingIgnoreCase(String name, Integer pageNumber, Integer pageSize);

    boolean existsBySlug(String slug);
}
