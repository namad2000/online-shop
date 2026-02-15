//package ir.online.shop.presentation.rest;
//
//import ir.online.commons.domain.model.PageData;
//import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
//import ir.online.shop.application.port.in.model.result.category.CategoryResult;
//import ir.online.shop.application.port.in.usecase.CategoryUseCase;
//import ir.online.shop.presentation.rest.dto.req.category.CreateCategoryRequest;
//import ir.online.shop.presentation.rest.dto.res.category.CategoryResponse;
//import ir.online.shop.presentation.rest.mapper.CategoryCommandMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/category")
//@RequiredArgsConstructor
//public class CategoryResource {
//
//    private final CategoryUseCase categoryUseCase;
//    private final CategoryCommandMapper categoryCommandMapper;
//
//    @PostMapping("/create")
//    public CategoryResponse create(
//            @RequestBody CreateCategoryRequest request) {
//        CreateCategoryCmd command = categoryCommandMapper.toCommand(request);
//        CategoryResult result = categoryUseCase.create(command);
//        return categoryCommandMapper.toResponse(result);
//    }
//
////    @PutMapping("/{categoryId}")
////    public CategoryResponse update(@RequestBody UpdateCategoryCmd request) {
////        return categoryUseCase.update(request);
////    }
//
//    @GetMapping("/all")
//    public PageData<CategoryResponse> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
//                                             @RequestParam(defaultValue = "10") Integer pageSize) {
//        return categoryCommandMapper.toResponseList(categoryUseCase.getAll(pageNumber, pageSize));
//    }
//
//    @GetMapping("/search")
//    public PageData<CategoryResponse> search(@RequestParam(required = false) String name,
//                                             @RequestParam(defaultValue = "0") Integer pageNumber,
//                                             @RequestParam(defaultValue = "10") Integer pageSize) {
//        return categoryCommandMapper.toResponseList(
//                categoryUseCase.search(name, pageNumber, pageSize)
//        );
//    }
//
//    @GetMapping("{id}")
//    public CategoryResponse getById(@PathVariable("id") UUID id) {
//        return categoryCommandMapper.toResponse(categoryUseCase.getById(id));
//    }
//
//    @GetMapping("list/childs/{parentId}")
//    public List<CategoryResponse> getChildrenByParentId(@PathVariable("parentId") UUID parentId) {
//        return categoryUseCase.getChildrenByParentId(parentId).stream().map(categoryCommandMapper::toResponse).toList();
//    }
//}
