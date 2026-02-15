package ir.online.shop.presentation.rest.brand;

import io.qoop.domain.model.PageData;
import ir.online.shop.application.port.in.usecase.BrandUseCase;
import ir.online.shop.presentation.rest.dto.req.brand.CreateBrandRequest;
import ir.online.shop.presentation.rest.dto.req.brand.UpdateBrandRequest;
import ir.online.shop.presentation.rest.dto.res.brand.BrandResponse;
import ir.online.shop.presentation.rest.mapper.BrandCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin/brand")
@RequiredArgsConstructor
public class BrandAdminResource {

    private final BrandUseCase brandUseCase;
    private final BrandCommandMapper brandCommandMapper;

    @PostMapping("/create")
    public UUID create(@RequestBody CreateBrandRequest request) {
        return brandUseCase.create(
                brandCommandMapper.toCommand(request)
        );
    }

    @PutMapping("/{id}")
    public UUID update(
            @PathVariable UUID id,
            @RequestBody UpdateBrandRequest request) {

        return brandUseCase.update(
                brandCommandMapper.toCommand(id, request)
        );
    }

    @GetMapping("/slug/{slug}")
    public BrandResponse getBySlug(@PathVariable String slug) {
        return brandCommandMapper.toResponse(
                brandUseCase.getBySlug(slug)
        );
    }

    @PatchMapping("/{id}/activate")
    public void activate(@PathVariable UUID id) {
        brandUseCase.activate(id);
    }

    @PatchMapping("/{id}/deactivate")
    public void deactivate(@PathVariable UUID id) {
        brandUseCase.deactivate(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        brandUseCase.delete(id);
    }

    @GetMapping("/all")
    public PageData<BrandResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandCommandMapper.toResponseList(
                brandUseCase.getAll(
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

        return brandCommandMapper.toResponseList(
                brandUseCase.search(
                        name,
                        pageNum,
                        pageSize
                )
        );
    }
}
