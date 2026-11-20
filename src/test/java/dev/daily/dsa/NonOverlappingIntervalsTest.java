package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NonOverlappingIntervalsTest {
    @Test
    void removesIntervalThatBlocksMoreSelections() {
        assertEquals(
                1,
                NonOverlappingIntervals.minimumRemovals(
                        new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    @Test
    void removesDuplicateOverlappingIntervals() {
        assertEquals(
                2,
                NonOverlappingIntervals.minimumRemovals(
                        new int[][] {{1, 2}, {1, 2}, {1, 2}}));
    }

    @Test
    void allowsTouchingIntervalsAndEmptyInput() {
        assertEquals(
                0,
                NonOverlappingIntervals.minimumRemovals(
                        new int[][] {{1, 2}, {2, 3}, {3, 4}}));
        assertEquals(
                0,
                NonOverlappingIntervals.minimumRemovals(new int[0][]));
    }

    @Test
    void doesNotModifyInput() {
        int[][] intervals = {{3, 4}, {1, 3}, {1, 2}};
        int[][] original = {{3, 4}, {1, 3}, {1, 2}};

        NonOverlappingIntervals.minimumRemovals(intervals);

        for (int index = 0; index < intervals.length; index++) {
            assertArrayEquals(original[index], intervals[index]);
        }
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> NonOverlappingIntervals.minimumRemovals(null));
        assertThrows(
                NullPointerException.class,
                () -> NonOverlappingIntervals.minimumRemovals(
                        new int[][] {null}));
        assertThrows(
                IllegalArgumentException.class,
                () -> NonOverlappingIntervals.minimumRemovals(
                        new int[][] {{1}}));
        assertThrows(
                IllegalArgumentException.class,
                () -> NonOverlappingIntervals.minimumRemovals(
                        new int[][] {{2, 2}}));
    }
}
