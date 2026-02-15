package ir.online.shop.presentation.rest.category;

import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
import ir.online.shop.application.port.in.model.result.category.CategoryResult;
import ir.online.shop.application.port.in.usecase.CategoryAdminQueryUseCase;
import ir.online.shop.presentation.rest.dto.req.category.CreateCategoryRequest;
import ir.online.shop.presentation.rest.dto.req.category.UpdateCategoryRequest;
import ir.online.shop.presentation.rest.dto.res.category.CategoryAdminResponse;
import ir.online.shop.presentation.rest.mapper.CategoryAdminCommandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin/category")
@RequiredArgsConstructor
public class CategoryAdminResource {

    private final CategoryAdminQueryUseCase categoryAdminQueryUseCase;
    private final CategoryAdminCommandMapper categoryMapper;

    @PostMapping("/create")
    public UUID create(@RequestBody CreateCategoryRequest request) {
        return categoryAdminQueryUseCase.create(
                categoryMapper.toCommand(request)
        );
    }

    @PutMapping("/{id}")
    public CategoryAdminResponse update(
            @PathVariable UUID id,
            @RequestBody UpdateCategoryRequest request) {
        UpdateCategoryCmd cmd = categoryMapper.toCommand(id, request);
        CategoryResult result = categoryAdminQueryUseCase.update(cmd);
        return categoryMapper.toResponse(result, 3);
    }

    @GetMapping("/{id}")
    public CategoryAdminResponse getById(@PathVariable UUID id) {
        return categoryMapper.toResponse(categoryAdminQueryUseCase.getById(id), 3);
    }

//    @GetMapping("/all")
//    public PageResult<CategoryAdminResponse> getAll(
//            @RequestParam(defaultValue = "0") Integer pageNum,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//        PageResult<CategoryResult> pageResult = categoryAdminQueryUseCase.getAll(PaginationRequest.of(pageNum, pageSize));
//        return
//                PageResult.of(
//                        pageResult.getTotalElements(),
//                        pageResult.getTotalPages(),
//                        categoryMapper.toResponseList(
//                                pageResult.getContents(), 3));
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        categoryAdminQueryUseCase.delete(id);
    }
}
