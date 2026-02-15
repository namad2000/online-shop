package ir.online.shop.presentation.rest.brand;

import io.qoop.domain.model.PageData;
import ir.online.shop.application.port.in.usecase.BrandQueryUseCase;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import ir.online.shop.presentation.rest.mapper.BrandQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller/brand")
@RequiredArgsConstructor
public class BrandSellerResource {

    private final BrandQueryUseCase brandQueryUseCase;
    private final BrandQueryMapper brandQueryMapper;

    @GetMapping("/available")
    public PageData<BrandResponse> getAvailableBrands(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseList(
                brandQueryUseCase.getBrandsForSeller(
                        pageNum,
                        pageSize
                )
        );
    }

    @GetMapping("/search")
    public PageData<BrandResponse> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseList(
                brandQueryUseCase.searchForSeller(
                        name,
                        pageNum,
                        pageSize
                )
        );
    }
}
