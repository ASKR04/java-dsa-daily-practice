package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSizeSubarraySumTest {
    @Test
    void returnsSmallestValidWindowLength() {
        assertEquals(2, MinimumSizeSubarraySum.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
    }

    @Test
    void returnsOneWhenSingleValueMeetsTarget() {
        assertEquals(1, MinimumSizeSubarraySum.minSubArrayLen(4, new int[] { 1, 4, 4 }));
    }

    @Test
    void returnsZeroWhenNoWindowMeetsTarget() {
        assertEquals(0, MinimumSizeSubarraySum.minSubArrayLen(11, new int[] { 1, 1, 1, 1 }));
    }

    @Test
    void handlesFullArrayAsOnlyValidWindow() {
        assertEquals(5, MinimumSizeSubarraySum.minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 }));
    }
}

