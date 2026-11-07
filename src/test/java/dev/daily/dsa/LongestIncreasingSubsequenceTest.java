package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {
    @Test
    void findsLongestIncreasingSubsequence() {
        assertEquals(
                4,
                LongestIncreasingSubsequence.length(
                        new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(
                4,
                LongestIncreasingSubsequence.length(
                        new int[] {0, 1, 0, 3, 2, 3}));
    }

    @Test
    void doesNotTreatEqualValuesAsIncreasing() {
        assertEquals(
                1,
                LongestIncreasingSubsequence.length(
                        new int[] {7, 7, 7, 7, 7}));
    }

    @Test
    void handlesEmptyAndSingleElementInputs() {
        assertEquals(
                0,
                LongestIncreasingSubsequence.length(new int[0]));
        assertEquals(
                1,
                LongestIncreasingSubsequence.length(new int[] {5}));
    }

    @Test
    void handlesNegativeValues() {
        assertEquals(
                4,
                LongestIncreasingSubsequence.length(
                        new int[] {-4, -2, -3, -1, 0}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {3, 1, 4, 2};
        int[] original = numbers.clone();

        LongestIncreasingSubsequence.length(numbers);

        assertArrayEquals(original, numbers);
    }

    @Test
    void rejectsNullInput() {
        assertThrows(
                NullPointerException.class,
                () -> LongestIncreasingSubsequence.length(null));
    }
}
