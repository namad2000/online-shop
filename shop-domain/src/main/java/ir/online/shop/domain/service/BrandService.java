package ir.online.shop.domain.service;


import io.qoop.domain.model.PageData;
import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import io.qoop.utils.api.SlugUtil;
import io.qoop.utils.api.StringUtil;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaStatus;
import ir.online.shop.domain.model.validator.BrandValidator;
import ir.online.shop.domain.repository.jpa.BrandRepository;

import java.util.UUID;

import static ir.online.shop.domain.exception.BrandExceptionCode.BRAND_NOT_FOUND;

@DomainService
public record BrandService(BrandRepository brandRepository, BrandValidator brandValidator) {

    // ---------- CREATE ----------
    public Brand create(Brand brand) {
        brandValidator.validateNameUnique(brand.getName());

        brand.setSlug(generateUniqueBrandSlug(brand));

        Brand newBrand = buildBrand(brand);

        return brandRepository.save(newBrand);
    }

    // ---------- UPDATE ----------
    public Brand update(Brand brand, Media media) {

        Brand existing = getById(brand.getId());

        brandValidator.validateNameUniqueWhenRenamed(existing, brand.getName());

        existing.setName(brand.getName());
        existing.setDescription(brand.getDescription());
        existing.setCountry(brand.getCountry());

        Media existingLogo = existing.getLogo();
        if (!existingLogo.equals(media)) {
            existingLogo.setMediaStatus(MediaStatus.DELETE);
        }

        return brandRepository.save(existing);
    }

    // ---------- GET BY ID ----------
    public Brand getById(UUID brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() ->
                        DomainException.of(BRAND_NOT_FOUND)
                );
    }

    // ---------- GET ACTIVE BY ID ----------
    public Brand getActiveById(UUID brandId) {
        Brand brand = getById(brandId);
        if (!brand.getIsActive()) {
            throw DomainException.of(BRAND_NOT_FOUND);
        }
        return brand;
    }

    // ---------- GET BY SLUG ----------
    public Brand getBySlug(String slug) {
        return brandRepository.findBySlug(slug)
                .orElseThrow(() -> DomainException.of(BRAND_NOT_FOUND));
    }

    // ---------- GET ACTIVE BY SLUG ----------
    public Brand getActiveBySlug(String slug) {
        Brand brand = getBySlug(slug);
        if (!brand.getIsActive()) {
            throw DomainException.of(BRAND_NOT_FOUND);
        }
        return brand;
    }


    // ---------- GET ALL ----------
    public PageData<Brand> getAll(Integer pageNumber, Integer pageSize) {
        return brandRepository.findAll(pageNumber, pageSize);
    }

    // ---------- GET ALL ACTIVE ----------
    public PageData<Brand> getAllActive(Integer pageNumber, Integer pageSize) {
        return brandRepository.findAllActive(pageNumber, pageSize);
    }

    // ---------- SEARCH BY NAME ----------
    public PageData<Brand> search(String name, Integer pageNumber, Integer pageSize) {
        return brandRepository.findAllByNameContainingIgnoreCase(name, pageNumber, pageSize);
    }

    // ---------- SEARCH ACTIVE ----------
    public PageData<Brand> searchActive(String name, Integer pageNumber, Integer pageSize) {
        return brandRepository.findAllActiveByNameContainingIgnoreCase(name, pageNumber, pageSize);
    }

    // BrandService
    public PageData<Brand> getBrandsForSeller(Integer pageNumber, Integer pageSize) {
        // فقط Active و Not Deleted
        return brandRepository.findAllActive(pageNumber, pageSize);
    }

    public PageData<Brand> searchForSeller(String name, Integer pageNumber, Integer pageSize) {
        return brandRepository.findAllActiveByNameContainingIgnoreCase(name, pageNumber, pageSize);
    }


    // ---------- DELETE ----------
    public void delete(UUID brandId) {

        Brand brand = getById(brandId);

        // Business Rule example (future-proof)
        // if (brand.hasProducts()) {
        //     throw DomainException.of(BrandExceptionCode.BRAND_03.name());
        // }

        brandRepository.delete(brand, true);
    }

    public void activate(UUID id) {
        changeBrandActivate(id, true);
    }

    public void deactivate(UUID id) {
        changeBrandActivate(id, false);
    }

    private String generateUniqueBrandSlug(Brand brand) {
        String brandSlug = StringUtil.isEmpty(brand.getSlug()) ? brand.getName() : brand.getSlug();

        String baseSlug = SlugUtil.toSlug(brandSlug);
        String slug = baseSlug;
        int counter = 1;

        while (brandRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter;
            counter++;
        }

        return slug;
    }

    // ---------- FACTORY METHOD ----------
    private Brand buildBrand(Brand brand) {
        return Brand.builder()
                .name(brand.getName())
                .description(brand.getDescription())
                .country(brand.getCountry())
                .slug(brand.getSlug())
                .isActive(true)
                .isDeleted(false)
                .build();
    }

    private void changeBrandActivate(UUID id, boolean active) {
        Brand brand = getById(id);
        brand.setIsActive(active);
        update(brand, brand.getLogo());
    }
}
