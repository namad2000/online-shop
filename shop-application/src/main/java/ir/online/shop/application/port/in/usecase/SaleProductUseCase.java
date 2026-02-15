package ir.online.shop.application.port.in.usecase;


import io.qoop.domain.model.PageData;
import io.qoop.filter.bean.api.UseCaseService;
import io.qoop.validation.api.IsValid;
import ir.online.shop.application.port.in.mapper.MediaMapper;
import ir.online.shop.application.port.in.mapper.ProductMapper;
import ir.online.shop.application.port.in.mapper.SaleProductMapper;
import ir.online.shop.application.port.in.model.cmd.sale.CreateSaleProductCmd;
import ir.online.shop.application.port.in.model.result.sale.SaleProductResult;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.domain.model.Vendor;
import ir.online.shop.domain.service.MediaService;
import ir.online.shop.domain.service.ProductService;
import ir.online.shop.domain.service.SaleProductService;
import ir.online.shop.domain.service.VendorService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@UseCaseService
@RequiredArgsConstructor
public class SaleProductUseCase {

    private final SaleProductService saleProductService;
    private final SaleProductMapper saleProductMapper;
    private final ProductService productService;
    private final VendorService vendorService;
    private final ProductMapper productMapper;
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;

    public SaleProductResult create(@IsValid CreateSaleProductCmd cmd) {
        BigDecimal original = cmd.getOriginalRetailPrice();
        BigDecimal retail = cmd.getRetailPrice() != null
                ? cmd.getRetailPrice()
                : original;

        SaleProduct newSaleProduct = saleProductMapper.toDomain(cmd);
        newSaleProduct.setOriginalRetailPrice(original);
        newSaleProduct.setRetailPrice(retail);

        newSaleProduct.checkIfPriceGreaterThanOriginal();

        Product product = productService.getById(cmd.getProductId());
        Vendor vendor = vendorService.getById(cmd.getVendorId());

        SaleProduct saleProduct = saleProductService.create(newSaleProduct, product, vendor);

        return saleProductMapper.toResult(saleProduct);
    }

    public SaleProductResult getById(UUID saleProductId) {
        SaleProductResult saleProductResult = saleProductMapper.toResult(saleProductService.getById(saleProductId));

        return saleProductResult;
    }

    public SaleProductResult getByIdActiveAndNotDeleted(UUID saleProductId) {
        SaleProductResult saleProductResult = saleProductMapper.toResult(saleProductService.getByIdActiveAndNotDeleted(saleProductId));

        return saleProductResult;
    }

    public PageData<SaleProductResult> search(
            String name,
            Long minPrice,
            Long maxPrice,
            Integer pageNumber,
            Integer pageSize
    ) {
        PageData<SaleProduct> search = saleProductService.searchByCustomer(
                name,
                minPrice,
                maxPrice,
                pageNumber,
                pageSize
        );
        List<SaleProduct> saleProducts = search.getContents();
        List<SaleProductResult> saleProductResultList = saleProductMapper.toResult(saleProducts, null);

        return PageData.of(
                search.getTotalElements(),
                search.getTotalPages(),
                saleProductResultList
        );
    }
}
