package ir.online.shop.presentation.rest.brand;

import io.qoop.domain.model.PageData;
import ir.online.shop.application.port.in.usecase.BrandQueryUseCase;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import ir.online.shop.presentation.rest.mapper.BrandQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/support/brand")
@RequiredArgsConstructor
public class BrandSupportResource {

    private final BrandQueryUseCase brandQueryUseCase;
    private final BrandQueryMapper brandQueryMapper;

    @GetMapping("/{id}")
    public BrandResponse getById(@PathVariable UUID id) {
        return brandQueryMapper.toResponse(
                brandQueryUseCase.getById(id)
        );
    }

    @GetMapping("/all")
    public PageData<BrandResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandQueryMapper.toResponseList(
                brandQueryUseCase.getAll(
                        pageNum,
                        pageSize
                )
        );
    }
}
