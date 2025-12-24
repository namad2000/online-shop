package ir.shop.online.core.presentation.rest;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.CreateCategory;
import ir.shop.online.core.domain.model.category.UpdateCategory;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
//    private final CategoryMapper categoryMapper;

    @PostMapping("/create")
    public Category create(
            @RequestBody CreateCategory request) {
        return categoryUseCase.create(request);
    }

    @PutMapping("/{categoryId}")
    public Category update(
            @PathVariable Integer categoryId,
            @RequestBody UpdateCategory request) {
        return categoryUseCase.update(categoryId, request);
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") Integer id) {
        return categoryUseCase.getById(id);
    }
}
