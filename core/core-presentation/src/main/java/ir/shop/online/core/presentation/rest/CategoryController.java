package ir.shop.online.core.presentation.rest;


import ir.shop.online.core.domain.usecase.CategoryUseCase;
import ir.shop.online.core.presentation.rest.dto.req.category.CreateCategoryRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryService;
//    private final CategoryMapper categoryMapper;

//    @PostMapping("/create")
//    public ResponseEntity<?> create(
//            @RequestBody CreateCategoryRequestDTO request) {
//        return ResponseEntity.ok(categoryMapper.toDTO(categoryService.create(request)));
//    }
//
//    @GetMapping("/{categoryId}")
//    public ResponseEntity<?> getUser(
//            @PathVariable Integer categoryId) {
//        return ResponseEntity.ok(categoryMapper.toDTO(categoryService.getById(categoryId)));
//    }

}
