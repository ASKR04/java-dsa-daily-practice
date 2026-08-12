package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumSortedTest {
    @Test
    void returnsOneBasedIndicesForMatchingPair() {
        assertArrayEquals(new int[] { 1, 2 }, TwoSumSorted.findPair(new int[] { 2, 7, 11, 15 }, 9));
    }

    @Test
    void findsPairInMiddleOfArray() {
        assertArrayEquals(new int[] { 2, 4 }, TwoSumSorted.findPair(new int[] { 1, 2, 3, 4, 6 }, 6));
    }

    @Test
    void handlesNegativeValues() {
        assertArrayEquals(new int[] { 1, 3 }, TwoSumSorted.findPair(new int[] { -3, -1, 0, 2, 4 }, -3));
    }

    @Test
    void handlesDuplicateValuesAsAnswer() {
        assertArrayEquals(new int[] { 2, 3 }, TwoSumSorted.findPair(new int[] { 1, 3, 3, 5 }, 6));
    }
}

