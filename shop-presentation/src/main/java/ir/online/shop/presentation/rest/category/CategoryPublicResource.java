//package ir.online.shop.presentation.rest.category;
//
//import ir.online.shop.application.port.in.model.result.PageResult;
//import ir.online.commons.domain.model.PaginationRequest;
//import ir.online.shop.application.port.in.usecase.CategoryQueryUseCase;
//import ir.online.shop.presentation.rest.dto.res.category.CategoryResponse;
//import ir.online.shop.presentation.rest.mapper.CategoryQueryMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/category")
//@RequiredArgsConstructor
//public class CategoryPublicResource {
//
//    private final CategoryQueryUseCase categoryQueryUseCase;
//    private final CategoryQueryMapper categoryMapper;
//
//    @GetMapping("/all")
//    public PageResult<CategoryResponse> getAll(
//            @RequestParam(defaultValue = "0") Integer pageNum,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//        return categoryMapper.toResponseList(
//                categoryQueryUseCase.getActiveCategories(PaginationRequest.of(pageNum, pageSize)), 2
//        );
//    }
//
//    @GetMapping("/search")
//    public PageResult<CategoryResponse> search(
//            @RequestParam String name,
//            @RequestParam(defaultValue = "0") Integer pageNum,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//        return categoryMapper.toResponseList(
//                categoryQueryUseCase.searchActive(name, PaginationRequest.of(pageNum, pageSize)), 2
//        );
//    }
//}
