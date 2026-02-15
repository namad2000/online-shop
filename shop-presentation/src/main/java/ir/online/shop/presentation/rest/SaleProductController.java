package ir.online.shop.presentation.rest;

import io.qoop.domain.model.PageData;
import ir.online.shop.application.port.in.model.cmd.sale.CreateSaleProductCmd;
import ir.online.shop.application.port.in.model.result.sale.SaleProductResult;
import ir.online.shop.application.port.in.usecase.SaleProductUseCase;
import ir.online.shop.presentation.rest.dto.req.sale.CreateSaleProductRequest;
import ir.online.shop.presentation.rest.dto.res.sale.SaleProductResponse;
import ir.online.shop.presentation.rest.mapper.SaleProductCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sale-product")
@RequiredArgsConstructor
public class SaleProductController {

    private final SaleProductUseCase saleProductUseCase;
    private final SaleProductCommandMapper saleProductCommandMapper;

    @PostMapping("/create")
    public SaleProductResponse create(
            @RequestBody CreateSaleProductRequest request) {
        CreateSaleProductCmd command = saleProductCommandMapper.toCommand(request);
        SaleProductResult productResult = saleProductUseCase.create(command);
        return saleProductCommandMapper.toResponse(productResult);
    }

    @GetMapping("/{saleProductId}")
    public SaleProductResponse getSaleProduct(
            @PathVariable UUID saleProductId) {
        return saleProductCommandMapper.toResponse(saleProductUseCase.getByIdActiveAndNotDeleted(saleProductId));
    }

    @GetMapping("/search")
    public PageData<SaleProductResponse> getSaleProduct(
            @RequestParam("name") String name,
            @RequestParam("minPrice") Long minPrice,
            @RequestParam("maxPrice") Long maxPrice,
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize
    ) {
        return saleProductCommandMapper.toResponse(saleProductUseCase.search(
                name,
                minPrice,
                maxPrice,
                pageNumber,
                pageSize
        ));
    }

}
