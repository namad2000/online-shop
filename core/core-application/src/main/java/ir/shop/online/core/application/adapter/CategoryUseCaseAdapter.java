package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.exception.ExceptionCode;
import ir.shop.online.core.domain.model.category.Category;
import ir.shop.online.core.domain.model.category.CreateCategory;
import ir.shop.online.core.domain.model.category.UpdateCategory;
import ir.shop.online.core.domain.repository.jpa.CategoryRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCaseService
@RequiredArgsConstructor
public class CategoryUseCaseAdapter implements CategoryUseCase {

    private final CategoryRepository categoryRepository;

    @IsValid
    @Override
    public Category create(CreateCategory createCategory) {

//        Optional<Category> parentCategory = null;
//
//        // اگر والد مشخص شده، باید وجود داشته باشد
//        if (createCategory.getParentId() != null) {
//            parentCategory = categoryRepository.findById(createCategory.getParentId())
//                    .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_03.name()));
//        } else {
//            // اگر والد ندادیم ولی قبلاً دسته‌ای بدون والد وجود دارد → اجازه نداریم
//            boolean rootExists = categoryRepository.existsByParentIsNull();
//            if (rootExists) {
//                throw new DomainException(ExceptionCode.CATEGORY_04.name()); // فقط یک دسته اول بدون والد
//            }
//        }
//
//        // بررسی وجود دسته با همان عنوان و والد
//        if (categoryRepository.existsByTitleAndParent(createCategory.getTitle(), parentCategory)) {
//            throw new DomainException(ExceptionCode.CATEGORY_01); // دسته تکراری با همان والد
//        }
//
//        // تعیین سطح
//        int level = (parentCategory == null) ? 0 : parentCategory.getLevel() + 1;
//
//        // ساخت دسته جدید
//        Category newCategory = Category.builder()
//                .title(createCategory.getTitle())
//                .description(createCategory.getDescription())
//                .parent(parentCategory)
//                .level(level)
//                .build();
//
//        categoryRepository.seve(newCategory);
        return null;
    }

    @Override
    public Category update(UpdateCategory createCategory) {
//        return categoryRepository.u;
        return null;
    }

    @Override
    public Category getById(Integer categoryId) {
//        return categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_02.name()));
        return null;
    }
}
