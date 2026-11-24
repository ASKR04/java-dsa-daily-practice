package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IntervalListIntersectionsTest {
    @Test
    void findsAllIntersectionsInOrder() {
        assertMatrixEquals(
                new int[][] {
                    {1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}
                },
                IntervalListIntersections.intersect(
                        new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    @Test
    void handlesEndpointIntersectionAndDisjointLists() {
        assertMatrixEquals(
                new int[][] {{2, 2}},
                IntervalListIntersections.intersect(
                        new int[][] {{0, 2}}, new int[][] {{2, 4}}));
        assertMatrixEquals(
                new int[0][],
                IntervalListIntersections.intersect(
                        new int[][] {{0, 1}}, new int[][] {{2, 3}}));
    }

    @Test
    void handlesEmptyList() {
        assertMatrixEquals(
                new int[0][],
                IntervalListIntersections.intersect(
                        new int[0][], new int[][] {{1, 2}}));
    }

    @Test
    void doesNotModifyInputs() {
        int[][] first = {{0, 2}, {5, 10}};
        int[][] second = {{1, 5}, {8, 12}};
        int[][] originalFirst = {{0, 2}, {5, 10}};
        int[][] originalSecond = {{1, 5}, {8, 12}};

        IntervalListIntersections.intersect(first, second);

        assertMatrixEquals(originalFirst, first);
        assertMatrixEquals(originalSecond, second);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> IntervalListIntersections.intersect(
                        null, new int[0][]));
        assertThrows(
                NullPointerException.class,
                () -> IntervalListIntersections.intersect(
                        new int[0][], new int[][] {null}));
        assertThrows(
                IllegalArgumentException.class,
                () -> IntervalListIntersections.intersect(
                        new int[][] {{1, 3}, {2, 4}}, new int[0][]));
        assertThrows(
                IllegalArgumentException.class,
                () -> IntervalListIntersections.intersect(
                        new int[][] {{3, 2}}, new int[0][]));
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertArrayEquals(expected, actual);
    }
}
