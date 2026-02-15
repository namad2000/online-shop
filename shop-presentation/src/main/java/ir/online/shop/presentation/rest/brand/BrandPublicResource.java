package ir.online.shop.presentation.rest.brand;

import io.qoop.domain.model.PageData;
import ir.online.shop.application.port.in.model.result.brand.BrandResult;
import ir.online.shop.application.port.in.usecase.BrandQueryUseCase;
import ir.online.shop.presentation.rest.dto.res.brand.BrandComboResponse;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import ir.online.shop.presentation.rest.mapper.BrandQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/public/brand")
@RequiredArgsConstructor
public class BrandPublicResource {

    private final BrandQueryUseCase brandQueryUseCase;
    private final BrandQueryMapper brandQueryMapper;

    @GetMapping("/{id}")
    public BrandResponse getById(@PathVariable UUID id) {
        return brandQueryMapper.toResponse(
                brandQueryUseCase.getActiveById(id)
        );
    }

    @GetMapping("/combo/{id}")
    public BrandComboResponse getByIdForCombo(@PathVariable UUID id) {
        BrandResult result = brandQueryUseCase.getById(id);
        return BrandComboResponse.builder()
                .id(result.getId())
                .name(result.getName())
                .build();
    }

    @GetMapping("/combo/all")
    public PageData<BrandComboResponse> getAllForCombo(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseComboList(
                brandQueryUseCase.getAllForCombo(
                        pageNum,
                        pageSize
                )
        );
    }

    @GetMapping("/slug/{slug}")
    public BrandResponse getBySlug(@PathVariable String slug) {
        return brandQueryMapper.toResponse(
                brandQueryUseCase.getActiveBySlug(slug)
        );
    }

    @GetMapping("/all")
    public PageData<BrandResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseList(
                brandQueryUseCase.getAllActive(
                        pageNum, pageSize
                )
        );
    }

    @GetMapping("/search")
    public PageData<BrandResponse> search(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseList(
                brandQueryUseCase.searchActive(
                        name,
                        pageNum,
                        pageSize
                )
        );
    }
}
