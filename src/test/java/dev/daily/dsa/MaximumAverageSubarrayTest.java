package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarrayTest {
    @Test
    void findsMaximumAverageForFixedWindow() {
        assertEquals(12.75, MaximumAverageSubarray.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4), 0.00001);
    }

    @Test
    void handlesWindowOfOne() {
        assertEquals(5.0, MaximumAverageSubarray.findMaxAverage(new int[] { -1, 5, 0 }, 1), 0.00001);
    }

    @Test
    void handlesWindowEqualToFullArray() {
        assertEquals(2.5, MaximumAverageSubarray.findMaxAverage(new int[] { 1, 2, 3, 4 }, 4), 0.00001);
    }

    @Test
    void handlesAllNegativeValues() {
        assertEquals(-2.0, MaximumAverageSubarray.findMaxAverage(new int[] { -5, -2, -3, -4 }, 1), 0.00001);
    }
}

