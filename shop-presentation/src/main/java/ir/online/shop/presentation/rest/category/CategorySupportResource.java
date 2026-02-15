//package ir.online.shop.presentation.rest.category;
//
//import ir.online.shop.application.port.in.model.result.PageResult;
//import ir.online.commons.domain.model.PaginationRequest;
//import ir.online.shop.application.port.in.usecase.CategoryQueryUseCase;
//import ir.online.shop.presentation.rest.dto.res.category.CategoryAdminResponse;
//import ir.online.shop.presentation.rest.mapper.CategoryQueryMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/support/category")
//@RequiredArgsConstructor
//public class CategorySupportResource {
//
//    private final CategoryQueryUseCase categoryQueryUseCase;
//    private final CategoryQueryMapper categoryMapper;
//
//    @GetMapping("/{id}")
//    public CategoryAdminResponse getById(@PathVariable UUID id) {
//        return categoryMapper.toResponse(categoryQueryUseCase.getById(id), 3);
//    }
//
//    @GetMapping("/all")
//    public PageResult<CategoryAdminResponse> getAll(
//            @RequestParam(defaultValue = "0") Integer pageNum,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//        return categoryMapper.toResponseList(
//                categoryQueryUseCase.getAll(PaginationRequest.of(pageNum, pageSize)), 3);
//    }
//
//    @PutMapping("/{id}/activate")
//    public void activate(@PathVariable UUID id) {
//        categoryQueryUseCase.activate(id);
//    }
//
//    @PutMapping("/{id}/deactivate")
//    public void deactivate(@PathVariable UUID id) {
//        categoryQueryUseCase.deactivate(id);
//    }
//}
