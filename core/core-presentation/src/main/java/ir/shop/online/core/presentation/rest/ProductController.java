package ir.shop.online.core.presentation.rest;

import ir.shop.online.core.domain.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

//    private final ProductUseCase productUseCase;
//    private final ProductMapper productMapper;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(
//            @RequestBody CreateProductRequest request) {
//        return ResponseEntity.ok(productMapper.toDTO(productUseCase.create(request)));
//    }
//
//    @GetMapping("/{productId}")
//    public ResponseEntity<?> getUser(
//            @PathVariable Long productId) {
//        return ResponseEntity.ok(productMapper.toDTO(productUseCase.getById(productId)));
//    }

}
