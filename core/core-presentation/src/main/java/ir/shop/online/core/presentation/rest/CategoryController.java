package ir.shop.online.core.presentation.rest;

import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.domain.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
//    private final CategoryMapper categoryMapper;

    @PostMapping("/create")
    public Category create(
            @RequestBody CreateCategoryCmd request) {
        return categoryUseCase.create(request);
    }

    @PutMapping("/{categoryId}")
    public Category update(
            @PathVariable Integer categoryId,
            @RequestBody UpdateCategoryCmd request) {
        return categoryUseCase.update(categoryId, request);
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") Integer id) {
        return categoryUseCase.getById(id);
    }
}
