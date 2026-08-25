package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {
    @Test
    void returnsIndexWhenTargetExists() {
        int[] nums = {1, 3, 5, 6};

        assertEquals(2, SearchInsertPosition.searchInsert(nums, 5));
    }

    @Test
    void returnsMiddleInsertionIndex() {
        int[] nums = {1, 3, 5, 6};

        assertEquals(1, SearchInsertPosition.searchInsert(nums, 2));
    }

    @Test
    void returnsEndInsertionIndex() {
        int[] nums = {1, 3, 5, 6};

        assertEquals(4, SearchInsertPosition.searchInsert(nums, 7));
    }

    @Test
    void returnsStartInsertionIndex() {
        int[] nums = {1, 3, 5, 6};

        assertEquals(0, SearchInsertPosition.searchInsert(nums, 0));
    }

    @Test
    void handlesEmptyArray() {
        assertEquals(0, SearchInsertPosition.searchInsert(new int[0], 10));
    }
}
