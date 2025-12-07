package ir.shop.online.commons.util.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CardMaskerPerformanceTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("ماسک کردن ۱۰۰۰ شماره کارت در کمتر از ۱۰۰ میلی‌ثانیه")
    void maskCardNumber_PerformanceTest() {
        // Given
        String cardNumber = "6037991234567890";

        // When & Then
        for (int i = 0; i < 1000; i++) {
            String result = CardMasker.maskCardNumber(cardNumber + i);
            assertThat(result).isNotNull();
        }
    }

    @Test
    @DisplayName("مقایسه عملکرد دو متد")
    void performanceComparison() {
        // Given
        String cardNumber = "6037-9912-3456-7890";
        int iterations = 10000;

        // زمان‌سنجی برای متد اول
        long startTime1 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            CardMasker.maskCardNumber(cardNumber);
        }
        long duration1 = System.nanoTime() - startTime1;

        // زمان‌سنجی برای متد دوم
        long startTime2 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            CardMasker.maskCardNumberWithSpaces(cardNumber);
        }
        long duration2 = System.nanoTime() - startTime2;

        System.out.printf("maskCardNumber: %d ns per call%n", duration1 / iterations);
        System.out.printf("maskCardNumberWithSpaces: %d ns per call%n", duration2 / iterations);

        // تایید قابل قبول بودن عملکرد
        assertThat(duration1).isLessThan(100_000_000); // کمتر از ۱۰۰ میلی‌ثانیه برای ۱۰۰۰۰ بار
    }
}
