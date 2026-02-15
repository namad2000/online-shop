package ir.online.shop.infrastructure.persistence.repository.jpa;


import io.qoop.domain.model.PageData;
import ir.online.shop.domain.model.Vendor;
import ir.online.shop.domain.repository.jpa.VendorRepository;
import ir.online.shop.infrastructure.persistence.entity.VendorEntity;
import ir.online.shop.infrastructure.persistence.mapper.VendorMapper;
import ir.online.shop.infrastructure.persistence.repository.jpa.spring.VendorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class VendorRepositoryAdapter implements VendorRepository {

    private final VendorJpaRepository vendorJpaRepository;
    private final VendorMapper vendorMapper;

    @Override
    public Vendor save(Vendor vendor) {
        VendorEntity vendorEntity = vendorMapper.toEntity(vendor);
        vendorEntity = vendorJpaRepository.save(vendorEntity);

        return vendorMapper.toDomain(vendorEntity);
    }

    @Override
    public Optional<Vendor> findById(UUID id) {
        return vendorJpaRepository.findById(id)
                .map(vendorMapper::toDomain);
    }

    @Override
    public Boolean existById(UUID id) {
        return vendorJpaRepository.existsById(id);
    }

    @Override
    public PageData<Vendor> findAll(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public void delete(Vendor domain, boolean logical) {

    }
}
