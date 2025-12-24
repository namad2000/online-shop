package ir.shop.online.commons.util.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    private UserMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UserMapper();
    }

    @Test
    void shouldMapSingleObjectWithoutContext() {
        UserEntity entity = new UserEntity(1L, "Davood");

        UserDto dto = mapper.map(entity);

        assertEquals(1L, dto.getId());
        assertEquals("Davood", dto.getFullName());
    }

    @Test
    void shouldMapSingleObjectWithContext() {
        UserEntity entity = new UserEntity(1L, "Davood");

        MappingContext context = MappingContext.empty()
                .put("upper", true);

        UserDto dto = mapper.map(entity, context);

        assertEquals("DAVOOD", dto.getFullName());
    }

    @Test
    void shouldMapList() {
        List<UserEntity> users = List.of(
                new UserEntity(1L, "Ali"),
                new UserEntity(2L, "Reza")
        );

        List<UserDto> result = mapper.mapList(users, MappingContext.empty());

        assertEquals(2, result.size());
        assertEquals("Ali", result.get(0).getFullName());
        assertEquals("Reza", result.get(1).getFullName());
    }

    @Test
    void shouldMapSet() {
        Set<UserEntity> users = Set.of(
                new UserEntity(1L, "Ali"),
                new UserEntity(2L, "Reza")
        );

        Set<UserDto> result = mapper.mapSet(users, MappingContext.empty());

        assertEquals(2, result.size());
    }
}
