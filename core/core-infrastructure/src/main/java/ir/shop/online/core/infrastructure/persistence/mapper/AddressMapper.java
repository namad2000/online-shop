//package ir.shop.online.core.infrastructure.persistence.mapper;
//
//import ir.shop.online.core.domain.model.address.Address;
//import ir.shop.online.core.infrastructure.persistence.entity.AddressEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring")
//public interface AddressMapper {
//
//    @Mapping(target = "user", ignore = true) // برای جلوگیری از حلقه بی‌نهایت
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "createdBy", ignore = true)
//    @Mapping(target = "updatedBy", ignore = true)
//    @Mapping(target = "isDeleted", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "deletedBy", ignore = true)
//    @Mapping(target = "version", ignore = true)
//    AddressEntity toEntity(Address dto);
//
//    Address toDomain(AddressEntity addressEntity);
//}
