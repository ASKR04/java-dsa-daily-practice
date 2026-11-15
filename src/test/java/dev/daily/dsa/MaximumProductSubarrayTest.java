package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaximumProductSubarrayTest {
    @Test
    void findsBestProductBeforeAResettingNegative() {
        assertEquals(
                6,
                MaximumProductSubarray.maxProduct(
                        new int[] {2, 3, -2, 4}));
    }

    @Test
    void tracksMinimumProductForASecondNegative() {
        assertEquals(
                24,
                MaximumProductSubarray.maxProduct(
                        new int[] {-2, 3, -4}));
    }

    @Test
    void handlesZerosAndSingleValues() {
        assertEquals(
                0,
                MaximumProductSubarray.maxProduct(
                        new int[] {-2, 0, -1}));
        assertEquals(-2, MaximumProductSubarray.maxProduct(new int[] {-2}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {-2, 3, -4};
        int[] original = numbers.clone();

        MaximumProductSubarray.maxProduct(numbers);

        assertArrayEquals(original, numbers);
    }

    @Test
    void rejectsInvalidInputAndOverflow() {
        assertThrows(
                NullPointerException.class,
                () -> MaximumProductSubarray.maxProduct(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> MaximumProductSubarray.maxProduct(new int[0]));
        assertThrows(
                ArithmeticException.class,
                () -> MaximumProductSubarray.maxProduct(
                        new int[] {
                            Integer.MAX_VALUE,
                            Integer.MAX_VALUE,
                            Integer.MAX_VALUE
                        }));
    }
}
