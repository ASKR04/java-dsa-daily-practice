package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    @Test
    void returnsIndexWhenTargetExists() {
        int[] nums = {-1, 0, 3, 5, 9, 12};

        assertEquals(4, BinarySearch.search(nums, 9));
    }

    @Test
    void returnsNegativeOneWhenTargetDoesNotExist() {
        int[] nums = {-1, 0, 3, 5, 9, 12};

        assertEquals(-1, BinarySearch.search(nums, 2));
    }

    @Test
    void findsTargetAtFirstIndex() {
        int[] nums = {2, 4, 6, 8};

        assertEquals(0, BinarySearch.search(nums, 2));
    }

    @Test
    void findsTargetAtLastIndex() {
        int[] nums = {2, 4, 6, 8};

        assertEquals(3, BinarySearch.search(nums, 8));
    }

    @Test
    void handlesEmptyArray() {
        assertEquals(-1, BinarySearch.search(new int[0], 10));
    }
}
