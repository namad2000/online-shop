package ir.shop.online.core.presentation.rest;

import ir.shop.online.core.domain.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.domain.model.result.product.ProductResult;
import ir.shop.online.core.domain.usecase.ProductUseCase;
import ir.shop.online.core.presentation.rest.dto.req.product.CreateProductRequest;
import ir.shop.online.core.presentation.rest.dto.res.product.CreateProductResponse;
import ir.shop.online.core.presentation.rest.mapper.ProductCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductCommandMapper productMapper;

    @PostMapping("/create")
    public CreateProductResponse create(
            @RequestBody CreateProductRequest request) {
        CreateProductCmd command = productMapper.toCommand(request);
        ProductResult productResult = productUseCase.create(command);
        return productMapper.toResponse(productResult);
    }

//    @GetMapping("/{productId}")
//    public ResponseEntity<?> getUser(
//            @PathVariable Long productId) {
//        return ResponseEntity.ok(productMapper.toDTO(productUseCase.getById(productId)));
//    }

}
