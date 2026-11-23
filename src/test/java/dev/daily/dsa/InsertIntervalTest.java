package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InsertIntervalTest {
    @Test
    void insertsAndMergesOneOverlappingInterval() {
        assertMatrixEquals(
                new int[][] {{1, 5}, {6, 9}},
                InsertInterval.insert(
                        new int[][] {{1, 3}, {6, 9}},
                        new int[] {2, 5}));
    }

    @Test
    void mergesAcrossSeveralIntervals() {
        assertMatrixEquals(
                new int[][] {{1, 2}, {3, 10}, {12, 16}},
                InsertInterval.insert(
                        new int[][] {
                            {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
                        },
                        new int[] {4, 8}));
    }

    @Test
    void insertsBeforeAfterAndIntoEmptyInput() {
        assertMatrixEquals(
                new int[][] {{1, 2}, {3, 4}},
                InsertInterval.insert(
                        new int[][] {{3, 4}}, new int[] {1, 2}));
        assertMatrixEquals(
                new int[][] {{1, 2}, {3, 4}},
                InsertInterval.insert(
                        new int[][] {{1, 2}}, new int[] {3, 4}));
        assertMatrixEquals(
                new int[][] {{2, 5}},
                InsertInterval.insert(new int[0][], new int[] {2, 5}));
    }

    @Test
    void doesNotModifyInputs() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[][] original = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[] originalNewInterval = newInterval.clone();

        InsertInterval.insert(intervals, newInterval);

        assertMatrixEquals(original, intervals);
        assertArrayEquals(originalNewInterval, newInterval);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> InsertInterval.insert(null, new int[] {1, 2}));
        assertThrows(
                NullPointerException.class,
                () -> InsertInterval.insert(new int[0][], null));
        assertThrows(
                IllegalArgumentException.class,
                () -> InsertInterval.insert(
                        new int[][] {{1, 3}, {2, 4}}, new int[] {5, 6}));
        assertThrows(
                IllegalArgumentException.class,
                () -> InsertInterval.insert(
                        new int[][] {{3, 4}, {1, 2}}, new int[] {5, 6}));
        assertThrows(
                IllegalArgumentException.class,
                () -> InsertInterval.insert(
                        new int[0][], new int[] {3, 2}));
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertArrayEquals(expected, actual);
    }
}
