package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitArrayLargestSumTest {
    @Test
    void minimizesLargestSumForStandardCase() {
        int[] nums = {7, 2, 5, 10, 8};

        assertEquals(18, SplitArrayLargestSum.splitArray(nums, 2));
    }

    @Test
    void handlesThreeSubarrays() {
        int[] nums = {1, 4, 4};

        assertEquals(4, SplitArrayLargestSum.splitArray(nums, 3));
    }

    @Test
    void returnsTotalSumWhenOnlyOneSubarrayIsAllowed() {
        int[] nums = {1, 2, 3, 4, 5};

        assertEquals(15, SplitArrayLargestSum.splitArray(nums, 1));
    }

    @Test
    void returnsMaximumValueWhenEveryElementCanBeSeparate() {
        int[] nums = {2, 3, 1, 2, 4, 3};

        assertEquals(4, SplitArrayLargestSum.splitArray(nums, 6));
    }

    @Test
    void keepsOriginalOrderDuringGreedyCheck() {
        int[] nums = {10, 1, 1, 10};

        assertEquals(11, SplitArrayLargestSum.splitArray(nums, 2));
    }
}
