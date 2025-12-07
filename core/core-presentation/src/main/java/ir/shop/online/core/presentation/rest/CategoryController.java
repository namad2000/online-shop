package ir.shop.online.core.presentation.rest;

import ir.shop.online.application.dto.req.CreateCategoryRequest;
import ir.shop.online.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ir.shop.online.infrastructure.mapper.CategoryMapper categoryMapper;

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody CreateCategoryRequest request) {
        return ResponseEntity.ok(categoryMapper.toDTO(categoryService.create(request)));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getUser(
            @PathVariable Integer categoryId) {
        return ResponseEntity.ok(categoryMapper.toDTO(categoryService.getById(categoryId)));
    }

}
