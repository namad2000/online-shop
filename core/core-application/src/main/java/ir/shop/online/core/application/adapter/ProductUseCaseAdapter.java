package ir.shop.online.core.application.adapter;

import ir.shop.online.Infrastructure.repository.ProductRepository;
import ir.shop.online.application.dto.req.CreateProductRequest;
import ir.shop.online.application.service.CategoryService;
import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.ProductUseCase;
import ir.shop.online.domain.exception.DomainException;
import ir.shop.online.domain.exception.ExceptionCode;
import ir.shop.online.domain.model.entity.Category;
import ir.shop.online.domain.model.entity.Product;
import ir.shop.online.domain.model.entity.ProductImage;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class ProductUseCaseAdapter implements ProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product create(CreateProductRequest request) {

        // بررسی وجود دسته‌بندی
        Category category = categoryService.getById(request.getCategoryId());

        // بررسی عدم تکراری بودن محصول در همان دسته
        boolean exists = productRepository.existsByNameAndCategory(request.getTitle(), category);
        if (exists) {
            throw new DomainException(ExceptionCode.PRODUCT_01); // محصول با این نام در دسته موجود است
        }

        // ایجاد محصول
        Product product = Product.builder()
                .name(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStock())
                .sku(request.getSku())
                .category(category)
                .build();

        // افزودن تصاویر
        if (request.getImageUrls() != null) {
            request.getImageUrls().forEach(url -> {
                ProductImage image = ProductImage.builder()
                        .url(url)
                        .isMain(false)
                        .product(product)
                        .build();
                product.getImages().add(image);
            });
        }

        return productRepository.save(product);
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new DomainException(ExceptionCode.PRODUCT_02));
    }
}
