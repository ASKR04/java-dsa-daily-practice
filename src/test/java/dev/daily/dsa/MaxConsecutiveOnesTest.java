package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesTest {
    @Test
    void findsLongestWindowAfterFlippingAtMostKZeroes() {
        assertEquals(6, MaxConsecutiveOnes.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
    }

    @Test
    void handlesKZeroAsPlainConsecutiveOnes() {
        assertEquals(3, MaxConsecutiveOnes.longestOnes(new int[] { 1, 1, 0, 1, 1, 1, 0 }, 0));
    }

    @Test
    void handlesAllOnes() {
        assertEquals(4, MaxConsecutiveOnes.longestOnes(new int[] { 1, 1, 1, 1 }, 2));
    }

    @Test
    void handlesAllZeroesWithLimitedFlips() {
        assertEquals(2, MaxConsecutiveOnes.longestOnes(new int[] { 0, 0, 0, 0 }, 2));
    }
}

