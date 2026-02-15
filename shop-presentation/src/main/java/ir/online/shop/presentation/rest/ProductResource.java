package ir.online.shop.presentation.rest;

import ir.online.shop.application.port.in.usecase.ProductUseCase;
import ir.online.shop.application.port.in.model.cmd.product.CreateProductCmd;
import ir.online.shop.application.port.in.model.result.product.ProductResult;
import ir.online.shop.presentation.rest.dto.req.product.CreateProductRequest;
import ir.online.shop.presentation.rest.dto.res.product.ProductResponse;
import ir.online.shop.presentation.rest.mapper.ProductCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductUseCase productUseCase;
    private final ProductCommandMapper productMapper;

    @PostMapping("/create")
    public ProductResponse create(
            @RequestBody CreateProductRequest request) {
        CreateProductCmd command = productMapper.toCommand(request);
        ProductResult productResult = productUseCase.create(command);
        return productMapper.toResponse(productResult);
    }

    @GetMapping("/{productId}")
    public ProductResponse getProduct(
            @PathVariable UUID productId) {
        return productMapper.toResponse(productUseCase.getById(productId));
    }

}
