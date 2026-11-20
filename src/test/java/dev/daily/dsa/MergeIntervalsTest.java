package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {
    @Test
    void mergesOverlappingRanges() {
        assertMatrixEquals(
                new int[][] {{1, 6}, {8, 10}, {15, 18}},
                MergeIntervals.merge(
                        new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }

    @Test
    void mergesTouchingAndNestedRanges() {
        assertMatrixEquals(
                new int[][] {{1, 5}},
                MergeIntervals.merge(new int[][] {{1, 4}, {4, 5}}));
        assertMatrixEquals(
                new int[][] {{1, 10}},
                MergeIntervals.merge(
                        new int[][] {{2, 3}, {1, 10}, {4, 8}}));
    }

    @Test
    void handlesEmptyInput() {
        assertMatrixEquals(new int[0][], MergeIntervals.merge(new int[0][]));
    }

    @Test
    void doesNotModifyInput() {
        int[][] intervals = {{8, 10}, {1, 3}, {2, 6}};
        int[][] original = {{8, 10}, {1, 3}, {2, 6}};

        MergeIntervals.merge(intervals);

        assertMatrixEquals(original, intervals);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> MergeIntervals.merge(null));
        assertThrows(
                NullPointerException.class,
                () -> MergeIntervals.merge(new int[][] {null}));
        assertThrows(
                IllegalArgumentException.class,
                () -> MergeIntervals.merge(new int[][] {{1}}));
        assertThrows(
                IllegalArgumentException.class,
                () -> MergeIntervals.merge(new int[][] {{3, 2}}));
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertArrayEquals(expected, actual);
    }
}
