package ir.shop.online.Infrastructure.mapper;

import ir.shop.online.application.dto.AddressDTO;
import ir.shop.online.domain.model.entity.Address;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "user", ignore = true) // برای جلوگیری از حلقه بی‌نهایت
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    Address toEntity(AddressDTO dto);

    AddressDTO toDTO(Address entity);
}
