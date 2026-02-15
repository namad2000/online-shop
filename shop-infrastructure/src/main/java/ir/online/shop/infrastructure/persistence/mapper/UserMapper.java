package ir.online.shop.infrastructure.persistence.mapper;//package ir.online.shop.infrastructure.persistence.mapper;
//
//import ir.online.shop.domain.model.user.Customer;
//import ir.online.shop.infrastructure.persistence.entity.UserEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(
//        componentModel = "spring",
//        uses = {AddressMapper.class}
//)
//public interface UserMapper {
//
//    @Mapping(target = "addresses", ignore = true)
//    @Mapping(target = "roles", expression = "java(mapStringsToRoles(user.getRoles()))")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "createdBy", ignore = true)
//    @Mapping(target = "updatedBy", ignore = true)
//    @Mapping(target = "isDeleted", ignore = true)
//    @Mapping(target = "deletedAt", ignore = true)
//    @Mapping(target = "deletedBy", ignore = true)
//    @Mapping(target = "version", ignore = true)
//    UserEntity toEntity(Customer user);
//
//    //    @Mapping(target = "addresses", ignore = true)
//    @Mapping(target = "roles", expression = "java(mapRolesToStrings(user.getRoles()))")
//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "isActive", ignore = true)
//    @Mapping(target = "lastLoginAt", ignore = true)
//    Customer toDomain(UserEntity userEntity);
//
//    // اگر می‌خواهی آدرس‌ها هم مپ شوند:
////    @AfterMapping
////    default void mapAddresses(Customer dto, @MappingTarget Customer entity, AddressMapper addressMapper) {
////        if (dto.getAddresses() != null) {
////            dto.getAddresses().forEach(a -> {
////                var address = addressMapper.toEntity(a);
////                address.setUser(entity); // ست کردن رابطه
////                entity.getAddresses().add(address);
////            });
////        }
////    }
////
////    @AfterMapping
////    default void mapAddresses(Customer user, @MappingTarget UserDTO dto, AddressMapper addressMapper) {
////        if (user.getAddresses() != null) {
////            dto.setAddresses(
////                    user.getAddresses()
////                            .stream()
////                            .map(addressMapper::toDomain)
////                            .toList()
////            );
////        }
////    }
////
////    // ---------- Custom Converters ----------
////    default Set<Role> mapStringsToRoles(Set<String> roles) {
////        if (roles == null) return null;
////        return roles.stream()
////                .map(r -> Role.builder().name(r).build())
////                .collect(Collectors.toSet());
////    }
////
////    default Set<String> mapRolesToStrings(Set<Role> roles) {
////        if (roles == null) return null;
////        return roles.stream()
////                .map(Role::getName)
////                .collect(Collectors.toSet());
////    }
//}
