package ir.shop.online.core.application.adapter;


import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.commons.domain.exception.DomainException;
import ir.shop.online.commons.domain.validation.IsValid;
import ir.shop.online.core.domain.exception.ProductExceptionCode;
import ir.shop.online.core.domain.model.Category;
import ir.shop.online.core.domain.model.Product;
import ir.shop.online.core.domain.model.ProductImage;
import ir.shop.online.core.domain.model.cmd.product.CreateProductCmd;
import ir.shop.online.core.domain.model.result.product.ProductResult;
import ir.shop.online.core.domain.repository.jpa.ProductRepository;
import ir.shop.online.core.domain.usecase.CategoryUseCase;
import ir.shop.online.core.domain.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;

@UseCaseService
@RequiredArgsConstructor
public class ProductUseCaseAdapter implements ProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryUseCase categoryUseCase;

    @Override
    public ProductResult create(@IsValid CreateProductCmd request) {

        // بررسی وجود دسته‌بندی
        Category category = categoryUseCase.getById(request.getCategoryId());

        // بررسی عدم تکراری بودن محصول در همان دسته
        boolean exists = productRepository.existsByNameAndCategory(request.getTitle(), category);
        if (exists) {
            throw new DomainException(ProductExceptionCode.PRODUCT_02.name()); // محصول با این نام در دسته موجود است
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
            Product finalProduct = product;
            request.getImageUrls().forEach(url -> {
                ProductImage image = ProductImage.builder()
                        .url(url)
                        .isMain(false)
                        .product(finalProduct)
                        .build();
                finalProduct.getImages().add(image);
            });
        }

        product = productRepository.save(product);
        return null;
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new DomainException(ProductExceptionCode.PRODUCT_02.name()));
    }
}
