package ir.shop.online.Infrastructure.mapper;

import ir.shop.online.application.dto.ProductDTO;
import ir.shop.online.domain.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product category);

}
