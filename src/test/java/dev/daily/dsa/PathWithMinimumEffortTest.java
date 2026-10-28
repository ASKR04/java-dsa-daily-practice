package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PathWithMinimumEffortTest {
    @Test
    void findsRouteThatMinimizesLargestStep() {
        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };

        assertEquals(2, PathWithMinimumEffort.minimumEffort(heights));
    }

    @Test
    void choosesLongerRouteWithSmallerEffort() {
        int[][] heights = {
            {1, 2, 3},
            {3, 8, 4},
            {5, 3, 5}
        };

        assertEquals(1, PathWithMinimumEffort.minimumEffort(heights));
    }

    @Test
    void handlesFlatAndSingleCellGrids() {
        assertEquals(
                0,
                PathWithMinimumEffort.minimumEffort(
                        new int[][] {{7, 7}, {7, 7}}));
        assertEquals(
                0,
                PathWithMinimumEffort.minimumEffort(new int[][] {{42}}));
    }

    @Test
    void handlesNegativeHeights() {
        int[][] heights = {
            {-5, -2},
            {-4, -1}
        };

        assertEquals(3, PathWithMinimumEffort.minimumEffort(heights));
    }

    @Test
    void handlesEmptyGrid() {
        assertEquals(0, PathWithMinimumEffort.minimumEffort(new int[0][]));
    }

    @Test
    void doesNotModifyHeights() {
        int[][] heights = {{1, 3}, {2, 4}};
        int[][] original = {heights[0].clone(), heights[1].clone()};

        PathWithMinimumEffort.minimumEffort(heights);

        assertArrayEquals(original[0], heights[0]);
        assertArrayEquals(original[1], heights[1]);
    }

    @Test
    void rejectsJaggedGrid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> PathWithMinimumEffort.minimumEffort(
                        new int[][] {{1, 2}, {3}}));
    }
}
