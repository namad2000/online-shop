package ir.online.shop.application.port.in.usecase;


import io.qoop.domain.model.PageData;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.validation.api.NotNull;
import ir.online.shop.application.port.in.mapper.BrandMapper;
import ir.online.shop.application.port.in.mapper.MediaMapper;
import ir.online.shop.application.port.in.model.result.brand.BrandComboResult;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.service.BrandService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class BrandQueryUseCase {

    private final BrandService brandService;
    private final BrandMapper brandMapper;
    private final MediaMapper mediaMapper;

    // ---------- GET BY ID ----------
    public BrandResult getById(@NotNull UUID brandId) {
        Brand brand = brandService.getById(brandId);
        BrandResult result = brandMapper.toResult(brand);
        result.setLogo(mediaMapper.toResult(brand.getLogo()));
        return result;
    }

    // ---------- GET ALL ----------
    public PageData<BrandComboResult> getAllForCombo(Integer pageNumber, Integer pageSize) {
        PageData<Brand> all = brandService.getAllActive(pageNumber, pageSize);
        List<Brand> brands = all.getContents();
        return PageData.of(
                all.getTotalElements(),
                all.getTotalPages(),
                brands.stream().map(x -> {
                    BrandComboResult result = BrandComboResult.builder()
                            .id(x.getId())
                            .name(x.getName())
                            .build();
                    return result;
                }).toList());
    }


    // ---------- GET ACTIVE BY ID ----------
    public BrandResult getActiveById(@NotNull UUID brandId) {
        Brand brand = brandService.getActiveById(brandId);
        BrandResult result = brandMapper.toResult(brand);
        result.setLogo(mediaMapper.toResult(brand.getLogo()));
        return result;
    }

    // ---------- GET ACTIVE BY SLUG ----------
    public BrandResult getActiveBySlug(@NotNull String slug) {
        Brand brand = brandService.getActiveBySlug(slug);
        BrandResult result = brandMapper.toResult(brand);
        result.setLogo(mediaMapper.toResult(brand.getLogo()));
        return result;
    }

    // ---------- GET ALL ----------
    public PageData<BrandResult> getAll(Integer pageNumber, Integer pageSize) {
        PageData<Brand> page = brandService.getAll(pageNumber, pageSize);
        return mapPage(page);
    }

    // ---------- GET ALL ACTIVE ----------
    public PageData<BrandResult> getAllActive(Integer pageNumber, Integer pageSize) {
        PageData<Brand> page = brandService.getAllActive(pageNumber, pageSize);
        return mapPage(page);
    }

    // ---------- SEARCH ----------
    public PageData<BrandResult> search(
            String name,
            Integer pageNumber, Integer pageSize) {

        PageData<Brand> page = brandService.search(name, pageNumber, pageSize);
        return mapPage(page);
    }

    // ---------- SEARCH ACTIVE ----------
    public PageData<BrandResult> searchActive(
            String name,
            Integer pageNumber, Integer pageSize) {

        PageData<Brand> page = brandService.searchActive(name, pageNumber, pageSize);
        return mapPage(page);
    }

    // BrandQueryUseCase
    public PageData<BrandResult> getBrandsForSeller(Integer pageNumber, Integer pageSize) {
        PageData<Brand> brands = brandService.getBrandsForSeller(pageNumber, pageSize);
        return mapPage(brands);
    }

    public PageData<BrandResult> searchForSeller(String name, Integer pageNumber, Integer pageSize) {
        PageData<Brand> brands = brandService.searchForSeller(name, pageNumber, pageSize);
        return mapPage(brands);
    }

    // ---------- PRIVATE MAPPER ----------
    private PageData<BrandResult> mapPage(PageData<Brand> page) {
        List<BrandResult> results = page.getContents()
                .stream()
                .map(brand -> {
                    BrandResult result = brandMapper.toResult(brand);
                    result.setLogo(mediaMapper.toResult(brand.getLogo()));
                    return result;
                })
                .toList();

        return PageData.of(
                page.getTotalElements(),
                page.getTotalPages(),
                results
        );
    }
}
