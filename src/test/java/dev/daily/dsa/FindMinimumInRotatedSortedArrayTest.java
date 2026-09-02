package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimumInRotatedSortedArrayTest {
    @Test
    void findsMinimumAfterRotation() {
        int[] nums = {3, 4, 5, 1, 2};

        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(nums));
    }

    @Test
    void findsMinimumInLargerRotatedArray() {
        int[] nums = {11, 13, 15, 17, 1, 3, 5, 7};

        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(nums));
    }

    @Test
    void handlesArrayWithoutRotation() {
        int[] nums = {1, 2, 3, 4, 5};

        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(nums));
    }

    @Test
    void handlesTwoElementRotation() {
        int[] nums = {2, 1};

        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(nums));
    }

    @Test
    void handlesSingleElementArray() {
        int[] nums = {9};

        assertEquals(9, FindMinimumInRotatedSortedArray.findMin(nums));
    }
}
