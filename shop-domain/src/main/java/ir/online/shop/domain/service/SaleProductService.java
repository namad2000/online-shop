package ir.online.shop.domain.service;

import io.qoop.domain.model.PageData;
import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.domain.model.Vendor;
import ir.online.shop.domain.repository.jpa.SaleProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static ir.online.shop.domain.exception.SaleProductExceptionCode.SALE_PRODUCT_IS_DUPLICATED;
import static ir.online.shop.domain.exception.SaleProductExceptionCode.SALE_PRODUCT_NOT_FOUND;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.online.shop.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class SaleProductService {
    private final SaleProductRepository saleProductRepository;

    public SaleProduct create(SaleProduct newSale, Product product, Vendor vendor) {
        newSale.setProduct(product);
        newSale.setVendor(vendor);

        if (saleProductRepository.existsByProductIdAndVendorId(product.getId(), vendor.getId())) {
            throw DomainException.of(SALE_PRODUCT_IS_DUPLICATED);
        }

        return saleProductRepository.save(newSale);
    }

    public SaleProduct getById(UUID saleProductId) {
        return saleProductRepository.findById(saleProductId)
                .orElseThrow(() -> DomainException.of(SALE_PRODUCT_NOT_FOUND));
    }

    public SaleProduct getByIdActiveAndNotDeleted(UUID saleProductId) {
        return saleProductRepository.findByIdActiveAndNotDeleted(saleProductId)
                .orElseThrow(() -> DomainException.of(SALE_PRODUCT_NOT_FOUND));
    }

    public PageData<SaleProduct> searchByCustomer(
            String name,
            Long minPrice,
            Long maxPrice,
            Integer pageNumber,
            Integer pageSize
    ) {
        return saleProductRepository.findByNameAndPriceRangeActiveAndNotDeleted(name, minPrice, maxPrice, pageNumber, pageSize);
    }
}
