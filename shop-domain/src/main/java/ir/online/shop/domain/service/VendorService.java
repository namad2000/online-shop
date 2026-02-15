package ir.online.shop.domain.service;

import io.qoop.fault.handler.api.exception.DomainException;
import io.qoop.filter.bean.api.DomainService;
import ir.online.shop.domain.exception.VendorExceptionCode;
import ir.online.shop.domain.model.Vendor;
import ir.online.shop.domain.repository.jpa.VendorRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 12/27/2025 12:46 PM
 * Package: ir.online.shop.domain.service
 */

@DomainService
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;

//    public Product create(Product newProduct, Category category, Brand brand) {
//        newProduct.setCategory(category);
//        newProduct.setBrand(brand);
//
//        if (vendorRepository.existsBySku(newProduct.getSku())) {
//            throw DomainException.of(PRODUCT_03.name());
//        }
//
//        boolean exists = vendorRepository.existsByNameAndCategory(newProduct.getName(), category);
//        if (exists) {
//            throw DomainException.of(ProductExceptionCode.PRODUCT_02.name());
//        }
//
//        return vendorRepository.save(newProduct);
//    }

    public Vendor getById(UUID vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> DomainException.of(VendorExceptionCode.VENDOR_NOT_FOUND));
    }
}
