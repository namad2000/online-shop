package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import ir.online.shop.domain.exception.ProductExceptionCode;
import ir.online.shop.domain.model.Brand;
import ir.online.shop.domain.model.Category;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.repository.jpa.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/30/2025 10:41 AM
 * Package: ir.online.shop.domain.service
 */


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private Category category;
    private Brand brand;

    private UUID productId = UUID.randomUUID();
    private UUID brandId = UUID.randomUUID();
    private UUID categoryId = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(categoryId);
        category.setName("Electronics");

        brand = new Brand();
        brand.setId(brandId);
        brand.setName("Samsung");

        product = new Product();
        product.setId(productId);
        product.setName("iPhone");
        product.setSku("SKU-123");
    }

    @Test
    void create_shouldThrowException_whenSkuExists() {
        // given
        when(productRepository.existsBySku(product.getSku()))
                .thenReturn(true);

        // when & then
        DomainException exception = assertThrows(
                DomainException.class,
                () -> productService.create(product, category, brand)
        );

        assertEquals(ProductExceptionCode.PRODUCT_SKU_IS_DUPLICATED, exception.getCode());
        verify(productRepository, never()).save(any());
    }

    @Test
    void create_shouldThrowException_whenNameExistsInCategory() {
        // given
        when(productRepository.existsBySku(product.getSku()))
                .thenReturn(false);

        when(productRepository.existsByNameAndCategory(product.getName(), category))
                .thenReturn(true);

        // when & then
        DomainException exception = assertThrows(
                DomainException.class,
                () -> productService.create(product, category, brand)
        );

        assertEquals(ProductExceptionCode.PRODUCT_EXIST_IN_CATEGORY, exception.getCode());
        verify(productRepository, never()).save(any());
    }

    @Test
    void create_shouldSaveProduct_whenValid() {
        // given
        when(productRepository.existsBySku(product.getSku()))
                .thenReturn(false);

        when(productRepository.existsByNameAndCategory(product.getName(), category))
                .thenReturn(false);

        when(productRepository.save(product))
                .thenReturn(product);

        // when
        Product result = productService.create(product, category, brand);

        // then
        assertNotNull(result);
        assertEquals(category, result.getCategory());
        verify(productRepository).save(product);
    }

    @Test
    void getById_shouldReturnProduct_whenExists() {
        // given
        when(productRepository.findById(productId))
                .thenReturn(Optional.of(product));

        // when
        Product result = productService.getById(productId);

        // then
        assertNotNull(result);
        assertEquals(productId, result.getId());
    }

    @Test
    void getById_shouldThrowException_whenNotFound() {
        // given
        when(productRepository.findById(productId))
                .thenReturn(Optional.empty());

        // when & then
        DomainException exception = assertThrows(
                DomainException.class,
                () -> productService.getById(productId)
        );

        assertEquals(ProductExceptionCode.PRODUCT_NOT_FOUND, exception.getCode());
    }
}
