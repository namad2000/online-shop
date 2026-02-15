package ir.online.shop.application.port.in.mapper;

import io.qoop.filter.bean.api.DomainMapper;
import io.qoop.mapper.api.InputMapper;
import io.qoop.mapper.api.MappingContext;
import io.qoop.mapper.api.ResultMapper;
import ir.online.shop.application.port.in.model.cmd.sale.CreateSaleProductCmd;
import ir.online.shop.application.port.in.model.result.sale.SaleProductResult;
import ir.online.shop.domain.model.Product;
import ir.online.shop.domain.model.SaleProduct;
import ir.online.shop.domain.model.Vendor;

@DomainMapper
public class SaleProductMapper implements InputMapper<CreateSaleProductCmd, SaleProduct>, ResultMapper<SaleProduct, SaleProductResult> {

    @Override
    public SaleProduct toDomain(CreateSaleProductCmd cmd, MappingContext context) {
        return SaleProduct.builder()
                .product(cmd.getProductId() == null ? null : Product.builder().id(cmd.getProductId()).build())
                .vendor(cmd.getVendorId() == null ? null : Vendor.builder().id(cmd.getVendorId()).build())
                .originalRetailPrice(cmd.getOriginalRetailPrice())
                .retailPrice(cmd.getRetailPrice())
                .allowNegativeStock(cmd.getAllowNegativeStock())
                .stockQuantity(cmd.getStockQuantity())
                .build();
    }

    @Override
    public SaleProductResult toResult(SaleProduct saleProduct, MappingContext context) {
        return SaleProductResult.builder()
                .id(saleProduct.getId())
                .productId(saleProduct.getProduct().getId())
                .productName(saleProduct.getProduct().getName())
                .thumbnailImageUrl(saleProduct.getProduct().getMainThumbnailImage().getUrl())
                .vendorCommerceName(saleProduct.getVendor().getCommercialName())
                .originalRetailPrice(saleProduct.getOriginalRetailPrice())
                .retailPrice(saleProduct.getRetailPrice())
                .allowNegativeStock(saleProduct.getAllowNegativeStock())
                .stockQuantity(saleProduct.getStockQuantity())
                .build();
    }
}
