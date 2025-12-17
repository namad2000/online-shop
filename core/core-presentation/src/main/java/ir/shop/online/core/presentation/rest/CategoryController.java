package ir.shop.online.core.presentation.rest;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
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

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") Integer id) {
        return categoryUseCase.getById(id);
    }
}
