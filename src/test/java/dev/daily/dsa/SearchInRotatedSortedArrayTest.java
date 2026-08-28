package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {
    @Test
    void findsTargetInRightSortedHalf() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        assertEquals(4, SearchInRotatedSortedArray.search(nums, 0));
    }

    @Test
    void findsTargetInLeftSortedHalf() {
        int[] nums = {6, 7, 8, 1, 2, 3, 4, 5};

        assertEquals(1, SearchInRotatedSortedArray.search(nums, 7));
    }

    @Test
    void returnsNegativeOneWhenTargetIsMissing() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        assertEquals(-1, SearchInRotatedSortedArray.search(nums, 3));
    }

    @Test
    void handlesArrayWithoutRotation() {
        int[] nums = {1, 2, 3, 4, 5};

        assertEquals(3, SearchInRotatedSortedArray.search(nums, 4));
    }

    @Test
    void handlesSingleElementArray() {
        assertEquals(0, SearchInRotatedSortedArray.search(new int[] {1}, 1));
        assertEquals(-1, SearchInRotatedSortedArray.search(new int[] {1}, 0));
    }
}
