package ir.shop.online.commons.validation.aspect;

import ir.shop.online.commons.domain.exception.DomainValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Davood Akbari - 1404
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestValidationService.class,
        TestConfig.class,
})
public class ValidationAspectTest {

    @Autowired
    private TestValidationService service;

    @Test
    void testValidCase() {
        TestUser user = new TestUser("davood", new NestedInfo("admin"));

        assertDoesNotThrow(() -> {
            service.saveUser(user);
        });
    }

    @Test
    void testInvalidField() {
        TestUser user = new TestUser("", new NestedInfo("admin"));

        DomainValidationException ex = assertThrows(
                DomainValidationException.class,
                () -> service.saveInvalidUser(user)
        );

        assertEquals("name", ex.getParamName());
        assertEquals("MaxValidator-01", ex.getCode());
    }

    @Test
    void testNestedInvalidField() {
        TestUser user = new TestUser("davood", new NestedInfo(""));

        DomainValidationException ex = assertThrows(
                DomainValidationException.class,
                () -> service.saveInvalidUser(user)
        );

        assertEquals("title", ex.getParamName());
        assertEquals("MaxValidator-01", ex.getCode());
    }

    @Test
    void testMethodNotExecutedOnError() {
        TestUser user = new TestUser("", new NestedInfo("admin"));

        assertThrows(
                DomainValidationException.class,
                () -> service.saveInvalidUser(user)
        );

        // If you want, you can use a spy to ensure method body never executed
    }

    @Test
    void testMethodNotExecutedOnErrorWithParam() {

        DomainValidationException ex = assertThrows(
                DomainValidationException.class,
                () -> service.dummyMethod(" ")
        );

        assertEquals("param", ex.getParamName());
        assertEquals("MaxValidator-01", ex.getCode());
    }
}
