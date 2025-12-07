package ir.shop.online.commons.util.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class CardMaskerTest {

    @Test
    @DisplayName("ماسک کردن شماره کارت ۱۶ رقمی")
    void testMaskCardNumber_16Digits() {
        // Given
        String cardNumber = "6037991234567890";

        // When
        String result = CardMasker.maskCardNumber(cardNumber);

        // Then
        assertThat(result).isEqualTo("6037********7890");
    }

    @Test
    @DisplayName("ماسک کردن با فاصله")
    void testMaskCardNumberWithSpaces() {
        // Given
        String cardNumber = "6037991234567890";

        // When
        String result = CardMasker.maskCardNumberWithSpaces(cardNumber);

        // Then
        assertThat(result).isEqualTo("6037 **** **** 7890");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    @DisplayName("ماسک کردن ورودی‌های null یا خالی")
    void testMaskNullOrEmpty(String input) {
        // When
        String result = CardMasker.maskCardNumber(input);

        // Then
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("ماسک کردن American Express")
    void testMaskAmex() {
        // Given
        String cardNumber = "378282246310005";

        // When
        String result = CardMasker.maskCardNumber(cardNumber);

        // Then
        assertThat(result).isEqualTo("3782*******0005");
    }
}
