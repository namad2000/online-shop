//package ir.shop.online.core.application.adapter;
//
//
//import ir.shop.online.commons.domain.annotation.UseCaseService;
//import ir.shop.online.core.domain.model.product.Product;
//import ir.shop.online.core.domain.repository.jpa.ProductRepository;
//import ir.shop.online.core.domain.usecase.CategoryUseCase;
//import ir.shop.online.core.domain.usecase.ProductUseCase;
//import lombok.RequiredArgsConstructor;
//
//@UseCaseService
//@RequiredArgsConstructor
//public class ProductUseCaseAdapter implements ProductUseCase {
//
//    private final ProductRepository productRepository;
//    private final CategoryUseCase categoryUseCase;
//
//    @Override
//    public Product create( Product product) {
//
//        // بررسی وجود دسته‌بندی
//        Category category = categoryUseCase.getById(request.getCategoryId());
//
//        // بررسی عدم تکراری بودن محصول در همان دسته
//        boolean exists = productRepository.existsByNameAndCategory(request.getTitle(), category);
//        if (exists) {
//            throw new DomainException(ExceptionCode.PRODUCT_01); // محصول با این نام در دسته موجود است
//        }
//
//        // ایجاد محصول
//        Product product = Product.builder()
//                .name(request.getTitle())
//                .description(request.getDescription())
//                .price(request.getPrice())
//                .stockQuantity(request.getStock())
//                .sku(request.getSku())
//                .category(category)
//                .build();
//
//        // افزودن تصاویر
//        if (request.getImageUrls() != null) {
//            request.getImageUrls().forEach(url -> {
//                ProductImage image = ProductImage.builder()
//                        .url(url)
//                        .isMain(false)
//                        .product(product)
//                        .build();
//                product.getImages().add(image);
//            });
//        }
//
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Product getById(Long productId) {
//        return productRepository.findById(productId)
//                .orElseThrow(() -> new DomainException(ExceptionCode.PRODUCT_02));
//    }
//}
