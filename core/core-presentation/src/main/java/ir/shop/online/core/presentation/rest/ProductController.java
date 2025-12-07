package ir.shop.online.core.presentation.rest;

import ir.shop.online.Infrastructure.mapper.ProductMapper;
import ir.shop.online.application.dto.req.CreateProductRequest;
import ir.shop.online.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productMapper.toDTO(productService.create(request)));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getUser(
            @PathVariable Long productId) {
        return ResponseEntity.ok(productMapper.toDTO(productService.getById(productId)));
    }

}
