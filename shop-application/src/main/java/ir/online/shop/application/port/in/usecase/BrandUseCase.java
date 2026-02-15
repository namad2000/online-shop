package ir.online.shop.application.port.in.usecase;


import io.qoop.domain.model.PageData;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.transaction.api.DomainTransaction;
import io.qoop.validation.api.IsValid;
import io.qoop.validation.api.NotNull;
import ir.online.shop.application.port.in.mapper.BrandMapper;
import ir.online.shop.application.port.in.mapper.MediaMapper;
import ir.online.shop.application.port.in.mapper.UpdateBrandMapper;
import ir.online.shop.application.port.in.model.cmd.brand.CreateBrandCmd;
import ir.online.shop.application.port.in.model.cmd.brand.UpdateBrandCmd;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.model.enums.MediaType;
import ir.online.shop.domain.service.BrandService;
import ir.online.shop.domain.service.MediaService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class BrandUseCase {

    private final BrandService brandService;
    private final BrandMapper brandMapper;
    private final UpdateBrandMapper updateBrandMapper;
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;


    // ---------- CREATE ----------
    @DomainTransaction
    public UUID create(@IsValid CreateBrandCmd command) {
        Media media = mediaService.getMedia(command.getLogoId(), MediaType.IMAGE, MediaOwnerType.BRAND);
        Brand brand = brandMapper.toDomain(command);
        Brand savedBrand = brandService.create(brand);

        mediaService.assignAndUpdate(media, savedBrand.getId(), true);

        return savedBrand.getId();
    }

    // ---------- UPDATE ----------
    public UUID update(@IsValid UpdateBrandCmd command) {
        Brand brand = updateBrandMapper.toDomain(command);
        Brand updatedBrand = brandService.update(brand, brand.getLogo());
        return updatedBrand.getId();
    }

    // ---------- GET BY ID ----------
    public BrandResult getById(@NotNull UUID brandId) {
        Brand brand = brandService.getById(brandId);
        BrandResult brandResult = brandMapper.toResult(brand);
        brandResult.setLogo(mediaMapper.toResult(brand.getLogo()));
        return brandResult;
    }

    // ---------- GET BY SLUG ----------
    public BrandResult getBySlug(@NotNull String slug) {
        Brand brand = brandService.getBySlug(slug);
        BrandResult result = brandMapper.toResult(brand);
        result.setLogo(mediaMapper.toResult(brand.getLogo()));
        return result;
    }

    // ---------- GET ALL ----------
    public PageData<BrandResult> getAll(Integer pageNumber, Integer pageSize) {
        PageData<Brand> all = brandService.getAll(pageNumber, pageSize);
        List<Brand> brands = all.getContents();
        return PageData.of(
                all.getTotalElements(),
                all.getTotalPages(),
                brands.stream().map(x -> {
                    BrandResult result = brandMapper.toResult(x);
                    result.setLogo(mediaMapper.toResult(x.getLogo()));
                    return result;
                }).toList());
    }

    // ---------- SEARCH BY NAME ----------
    public PageData<BrandResult> search(String name, Integer pageNumber, Integer pageSize) {
        PageData<Brand> search = brandService.search(name, pageNumber, pageSize);
        List<Brand> brands = search.getContents();
        return PageData.of(
                search.getTotalElements(),
                search.getTotalPages(),
                brands.stream().map(x -> {
                    BrandResult result = brandMapper.toResult(x);
                    result.setLogo(mediaMapper.toResult(x.getLogo()));
                    return result;
                }).toList());
    }

    // ---------- DELETE ----------
    public void delete(@NotNull UUID brandId) {
        brandService.delete(brandId);
    }

    public void activate(UUID id) {
        brandService.activate(id);
    }

    public void deactivate(UUID id) {
        brandService.deactivate(id);
    }
}
