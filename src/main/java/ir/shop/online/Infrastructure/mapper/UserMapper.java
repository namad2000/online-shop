package ir.shop.online.Infrastructure.mapper;

import ir.shop.online.application.dto.UserDTO;
import ir.shop.online.domain.model.entity.Role;
import ir.shop.online.domain.model.entity.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = { AddressMapper.class }
)
public interface UserMapper {

    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "roles", expression = "java(mapStringsToRoles(dto.getRoles()))")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    User toEntity(UserDTO dto);

//    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "roles", expression = "java(mapRolesToStrings(user.getRoles()))")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    UserDTO toDTO(User user);

    // اگر می‌خواهی آدرس‌ها هم مپ شوند:
    @AfterMapping
    default void mapAddresses(UserDTO dto, @MappingTarget User entity, AddressMapper addressMapper) {
        if (dto.getAddresses() != null) {
            dto.getAddresses().forEach(a -> {
                var address = addressMapper.toEntity(a);
                address.setUser(entity); // ست کردن رابطه
                entity.getAddresses().add(address);
            });
        }
    }

    @AfterMapping
    default void mapAddresses(User user, @MappingTarget UserDTO dto, AddressMapper addressMapper) {
        if (user.getAddresses() != null) {
            dto.setAddresses(
                    user.getAddresses()
                            .stream()
                            .map(addressMapper::toDTO)
                            .toList()
            );
        }
    }

    // ---------- Custom Converters ----------
    default Set<Role> mapStringsToRoles(Set<String> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(r -> Role.builder().name(r).build())
                .collect(Collectors.toSet());
    }

    default Set<String> mapRolesToStrings(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
