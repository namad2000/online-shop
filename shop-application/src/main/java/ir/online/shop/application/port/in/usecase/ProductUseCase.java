package ir.online.shop.application.port.in.usecase;

import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.validation.api.IsValid;
import ir.online.shop.application.port.in.mapper.MediaMapper;
import ir.online.shop.application.port.in.mapper.ProductMapper;
import ir.online.shop.application.port.in.model.cmd.product.CreateProductCmd;
import ir.online.shop.application.port.in.model.result.media.MediaResult;
import ir.online.shop.application.port.in.model.result.product.ProductResult;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Media;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.model.enums.MediaOwnerType;
import ir.online.shop.domain.service.BrandService;
import ir.online.shop.domain.service.CategoryService;
import ir.online.shop.domain.service.MediaService;
import ir.online.shop.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;

    public ProductResult create(@IsValid CreateProductCmd cmd) {
        Product newProduct = productMapper.toDomain(cmd);

        Category category = categoryService.getById(newProduct.getCategory().getId());
        Brand brand = brandService.getById(newProduct.getBrand().getId());

        Product product = productService.create(newProduct, category, brand);

        List<MediaResult> mediaResults = new ArrayList<>();
        for (String url : cmd.getImageUrls()) {
            Media media = mediaService.getMediaByUrl(url, MediaOwnerType.PRODUCT);
            mediaService.assignAndUpdate(media, product.getId(), media.isMain());
            mediaResults.add(mediaMapper.toResult(media));
        }

        ProductResult productResult = productMapper.toResult(product);
        productResult.setMedias(mediaResults);
        return productResult;
    }

    public ProductResult getById(UUID productId) {
        ProductResult productResult = productMapper.toResult(productService.getById(productId));

        List<MediaResult> mediaResults = new ArrayList<>();
        List<Media> mediasByOwnerId = mediaService.getMediasByOwnerId(productId, MediaOwnerType.PRODUCT);
        for (Media media : mediasByOwnerId) {
            mediaResults.add(mediaMapper.toResult(media));
        }
        productResult.setMedias(mediaResults);

        return productResult;
    }
}
