package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindFirstAndLastPositionTest {
    @Test
    void findsFirstAndLastPositionForRepeatedTarget() {
        int[] nums = {5, 7, 7, 8, 8, 10};

        assertArrayEquals(
                new int[] {3, 4},
                FindFirstAndLastPosition.searchRange(nums, 8)
        );
    }

    @Test
    void returnsMissingRangeWhenTargetDoesNotExist() {
        int[] nums = {5, 7, 7, 8, 8, 10};

        assertArrayEquals(
                new int[] {-1, -1},
                FindFirstAndLastPosition.searchRange(nums, 6)
        );
    }

    @Test
    void handlesSingleTargetOccurrence() {
        int[] nums = {1, 2, 3, 4, 5};

        assertArrayEquals(
                new int[] {2, 2},
                FindFirstAndLastPosition.searchRange(nums, 3)
        );
    }

    @Test
    void handlesTargetAtBothEdges() {
        int[] nums = {2, 2, 2, 2};

        assertArrayEquals(
                new int[] {0, 3},
                FindFirstAndLastPosition.searchRange(nums, 2)
        );
    }

    @Test
    void handlesEmptyArray() {
        assertArrayEquals(
                new int[] {-1, -1},
                FindFirstAndLastPosition.searchRange(new int[0], 1)
        );
    }
}
