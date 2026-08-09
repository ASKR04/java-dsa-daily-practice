package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {
    @Test
    void mergesTwoSortedArraysInPlace() {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };

        MergeSortedArray.merge(nums1, 3, new int[] { 2, 5, 6 }, 3);

        assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, nums1);
    }

    @Test
    void keepsNums1WhenNums2IsEmpty() {
        int[] nums1 = { 1 };

        MergeSortedArray.merge(nums1, 1, new int[] {}, 0);

        assertArrayEquals(new int[] { 1 }, nums1);
    }

    @Test
    void fillsNums1WhenItHasNoInitialValues() {
        int[] nums1 = { 0 };

        MergeSortedArray.merge(nums1, 0, new int[] { 1 }, 1);

        assertArrayEquals(new int[] { 1 }, nums1);
    }

    @Test
    void handlesNums2ValuesThatAllBelongInFront() {
        int[] nums1 = { 4, 5, 6, 0, 0, 0 };

        MergeSortedArray.merge(nums1, 3, new int[] { 1, 2, 3 }, 3);

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, nums1);
    }
}

