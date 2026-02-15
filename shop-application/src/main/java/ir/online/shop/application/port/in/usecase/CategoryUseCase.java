//package ir.online.shop.application.port.in.usecase;
//
//import ir.online.commons.domain.model.PageData;
//import ir.online.commons.filter.bean.api.UseCaseService;
//import ir.online.commons.validation.api.IsValid;
//import ir.online.commons.validation.api.NotNull;
//import ir.online.shop.application.port.in.mapper.CategoryMapper;
//import ir.online.shop.application.port.in.mapper.MediaMapper;
//import ir.online.shop.application.port.in.mapper.UpdateCategoryMapper;
//import ir.online.shop.application.port.in.model.cmd.category.CreateCategoryCmd;
//import ir.online.shop.application.port.in.model.cmd.category.UpdateCategoryCmd;
//import ir.online.shop.application.port.in.model.result.category.CategoryResult;
//import ir.online.shop.domain.model.Category;
//import ir.online.shop.domain.service.CategoryService;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//import java.util.UUID;
//
//@UseCaseService
//@RequiredArgsConstructor
//public class CategoryUseCase {
//
//    private final CategoryService categoryService;
//    private final CategoryMapper categoryMapper;
//    private final UpdateCategoryMapper updateCategoryMapper;
//    private final MediaMapper mediaMapper;
//
//
//    public CategoryResult create(@IsValid CreateCategoryCmd createCategoryCmd) {
//        Category newCategory = categoryMapper.toDomain(createCategoryCmd);
//        Category save = categoryService.create(newCategory);
//        return categoryMapper.toResult(save);
//    }
//
//    // ---------- GET ALL ----------
//    public PageData<CategoryResult> getAll(Integer pageNumber, Integer pageSize) {
//        PageData<Category> all = categoryService.getAll(pageNumber, pageSize);
//        List<Category> categories = all.getContents();
//        return PageData.of(
//                all.getTotalElements(),
//                all.getTotalPages(),
//                categories.stream().map(x -> {
//                    CategoryResult result = categoryMapper.toResult(x);
//                    result.setMedia(mediaMapper.toResult(x.getMainImage()));
//                    return result;
//                }).toList());
//    }
//
//    // ---------- SEARCH BY NAME ----------
//    public PageData<CategoryResult> search(String name, Integer pageNumber, Integer pageSize) {
//        PageData<Category> search = categoryService.search(name, pageNumber, pageSize);
//        List<Category> categoies = search.getContents();
//        return PageData.of(
//                search.getTotalElements(),
//                search.getTotalPages(),
//                categoies.stream().map(x -> {
//                    CategoryResult result = categoryMapper.toResult(x);
//                    result.setMedia(mediaMapper.toResult(x.getMainImage()));
//                    return result;
//                }).toList());
//    }
//
//    public CategoryResult update(@IsValid UpdateCategoryCmd command) {
//        Category category = updateCategoryMapper.toDomain(command);
//        return categoryMapper.toResult(categoryService.update(category));
//    }
//
//    public CategoryResult getById(@NotNull UUID categoryId) {
//        return categoryMapper.toResult(categoryService.getById(categoryId));
//    }
//
//    public List<CategoryResult> getChildrenByParentId(UUID parentId) {
//        return categoryService.getChildrenByParentId(parentId)
//                .stream().map(categoryMapper::toResult).toList();
//    }
//}
