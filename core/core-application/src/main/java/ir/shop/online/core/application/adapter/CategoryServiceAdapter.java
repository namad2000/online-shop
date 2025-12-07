package ir.shop.online.core.application.adapter;

import ir.shop.online.Infrastructure.repository.CategoryRepository;
import ir.shop.online.application.dto.req.CreateCategoryRequest;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Category;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class CategoryServiceAdapter implements CategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CreateCategoryRequest request) {

        Category parentCategory = null;

        // اگر والد مشخص شده، باید وجود داشته باشد
        if (request.getParentId() != null) {
            parentCategory = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_03));
        } else {
            // اگر والد ندادیم ولی قبلاً دسته‌ای بدون والد وجود دارد → اجازه نداریم
            boolean rootExists = categoryRepository.existsByParentIsNull();
            if (rootExists) {
                throw new DomainException(ExceptionCode.CATEGORY_04); // فقط یک دسته اول بدون والد
            }
        }

        // بررسی وجود دسته با همان عنوان و والد
        if (categoryRepository.existsByTitleAndParent(request.getTitle(), parentCategory)) {
            throw new DomainException(ExceptionCode.CATEGORY_01); // دسته تکراری با همان والد
        }

        // تعیین سطح
        int level = (parentCategory == null) ? 0 : parentCategory.getLevel() + 1;

        // ساخت دسته جدید
        Category newCategory = Category.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .parent(parentCategory)
                .level(level)
                .build();

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DomainException(ExceptionCode.CATEGORY_02));
    }
}
