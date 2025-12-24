package ir.shop.online.core.presentation.rest;


import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
//    private final CategoryMapper categoryMapper;

//    @PostMapping("/create")
//    public Category create(
//            @RequestBody CreateCategory request) {
//        return categoryUseCase.create(request);
//    }

//    @PutMapping("/{categoryId}")
//    public Category update(
//            @PathVariable Integer categoryId,
//            @RequestBody UpdateCategory request) {
//        return categoryUseCase.update(categoryId, request);
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public Category getById(@PathParam("id") Integer id) {
        return categoryUseCase.getById(id);
    }
}
