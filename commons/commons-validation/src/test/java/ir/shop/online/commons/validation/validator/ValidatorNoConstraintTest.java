package ir.shop.online.commons.validation.validator;

import ir.shop.online.commons.validation.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidatorNoConstraintTest {

    @Test
    void testFieldWithoutConstraint() {
        TestDto dto = new TestDto("value");

        assertDoesNotThrow(() -> Validator.validate(dto));
    }
}
