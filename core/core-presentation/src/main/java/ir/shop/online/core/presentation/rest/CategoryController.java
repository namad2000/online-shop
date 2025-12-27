package ir.shop.online.core.presentation.rest;

import ir.shop.online.core.application.adapter.CategoryUseCase;
import ir.shop.online.core.application.model.cmd.category.CreateCategoryCmd;
import ir.shop.online.core.application.model.cmd.category.UpdateCategoryCmd;
import ir.shop.online.core.application.model.result.category.CategoryResult;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.presentation.rest.dto.req.category.CreateCategoryRequest;
import ir.shop.online.core.presentation.rest.dto.res.category.CategoryResponse;
import ir.shop.online.core.presentation.rest.mapper.CategoryCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
    private final CategoryCommandMapper categoryCommandMapper;

    @PostMapping("/create")
    public CategoryResponse create(
            @RequestBody CreateCategoryRequest request) {
        CreateCategoryCmd command = categoryCommandMapper.toCommand(request);
        CategoryResult result = categoryUseCase.create(command);
        return categoryCommandMapper.toResponse(result);
    }

    @PutMapping("/{categoryId}")
    public CategoryResponse update(@RequestBody UpdateCategoryCmd request) {
        return categoryUseCase.update(request);
    }

    @GetMapping("{id}")
    public CategoryResponse getById(@PathVariable("id") Integer id) {
        return categoryCommandMapper.toResponse(categoryUseCase.getById(id));
    }
}
