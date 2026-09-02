package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestDivisorGivenThresholdTest {
    @Test
    void findsSmallestDivisorForStandardCase() {
        int[] nums = {1, 2, 5, 9};

        assertEquals(5, SmallestDivisorGivenThreshold.smallestDivisor(nums, 6));
    }

    @Test
    void handlesLargerArrayAndThreshold() {
        int[] nums = {44, 22, 33, 11, 1};

        assertEquals(44, SmallestDivisorGivenThreshold.smallestDivisor(nums, 5));
    }

    @Test
    void returnsOneWhenThresholdAllowsOriginalSum() {
        int[] nums = {2, 3, 4};

        assertEquals(1, SmallestDivisorGivenThreshold.smallestDivisor(nums, 9));
    }

    @Test
    void handlesSingleValueInput() {
        int[] nums = {19};

        assertEquals(4, SmallestDivisorGivenThreshold.smallestDivisor(nums, 5));
    }

    @Test
    void stopsFeasibilityCheckOnceThresholdIsExceeded() {
        int[] nums = {100, 200, 300};

        assertEquals(300, SmallestDivisorGivenThreshold.smallestDivisor(nums, 3));
    }
}
