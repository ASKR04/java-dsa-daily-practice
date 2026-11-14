package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaximumSubarrayTest {
    @Test
    void findsBestContiguousRange() {
        assertEquals(
                6,
                MaximumSubarray.maxSum(
                        new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void choosesLargestValueWhenAllNumbersAreNegative() {
        assertEquals(-2, MaximumSubarray.maxSum(new int[] {-3, -2, -5}));
    }

    @Test
    void handlesSingleValueAndSumsBeyondIntegerRange() {
        assertEquals(-1, MaximumSubarray.maxSum(new int[] {-1}));
        assertEquals(
                4_294_967_294L,
                MaximumSubarray.maxSum(
                        new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {5, -2, 3};
        int[] original = numbers.clone();

        MaximumSubarray.maxSum(numbers);

        assertArrayEquals(original, numbers);
    }

    @Test
    void rejectsNullAndEmptyInputs() {
        assertThrows(
                NullPointerException.class,
                () -> MaximumSubarray.maxSum(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> MaximumSubarray.maxSum(new int[0]));
    }
}
