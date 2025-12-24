package ir.shop.online.commons.util.mapper;

class UserMapper implements Mapper<UserEntity, UserDto> {

    @Override
    public UserDto map(UserEntity in, MappingContext context) {
        UserDto dto = new UserDto();
        dto.setId(in.getId());

        Boolean upper = context.get("upper");
        String name = in.getName();

        dto.setFullName(Boolean.TRUE.equals(upper) ? name.toUpperCase() : name);
        return dto;
    }
}
