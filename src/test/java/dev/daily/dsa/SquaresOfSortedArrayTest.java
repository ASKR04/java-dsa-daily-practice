package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfSortedArrayTest {
    @Test
    void squaresMixedValuesIntoSortedOrder() {
        assertArrayEquals(
                new int[] { 0, 1, 9, 16, 100 },
                SquaresOfSortedArray.sortedSquares(new int[] { -4, -1, 0, 3, 10 }));
    }

    @Test
    void handlesAllNegativeValues() {
        assertArrayEquals(
                new int[] { 1, 4, 9, 49 },
                SquaresOfSortedArray.sortedSquares(new int[] { -7, -3, -2, -1 }));
    }

    @Test
    void handlesAllNonNegativeValues() {
        assertArrayEquals(
                new int[] { 0, 1, 4, 9 },
                SquaresOfSortedArray.sortedSquares(new int[] { 0, 1, 2, 3 }));
    }

    @Test
    void handlesSingleElementArray() {
        assertArrayEquals(
                new int[] { 25 },
                SquaresOfSortedArray.sortedSquares(new int[] { -5 }));
    }
}

