package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MinimumCostToConnectPointsTest {
    @Test
    void findsMinimumCostForSeveralPoints() {
        int[][] points = {
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        };

        assertEquals(20, MinimumCostToConnectPoints.minimumCost(points));
    }

    @Test
    void handlesNegativeCoordinates() {
        int[][] points = {
            {-2, -3},
            {-1, 4},
            {3, 1}
        };

        assertEquals(15, MinimumCostToConnectPoints.minimumCost(points));
    }

    @Test
    void connectsDuplicatePointsAtZeroCost() {
        int[][] points = {
            {1, 1},
            {1, 1},
            {4, 5}
        };

        assertEquals(7, MinimumCostToConnectPoints.minimumCost(points));
    }

    @Test
    void handlesEmptyAndSinglePointInputs() {
        assertEquals(0, MinimumCostToConnectPoints.minimumCost(new int[0][]));
        assertEquals(
                0,
                MinimumCostToConnectPoints.minimumCost(new int[][] {{8, -2}}));
    }

    @Test
    void doesNotModifyPoints() {
        int[][] points = {{0, 0}, {2, 3}, {-1, 4}};
        int[][] original = {points[0].clone(), points[1].clone(), points[2].clone()};

        MinimumCostToConnectPoints.minimumCost(points);

        assertArrayEquals(original[0], points[0]);
        assertArrayEquals(original[1], points[1]);
        assertArrayEquals(original[2], points[2]);
    }

    @Test
    void rejectsMalformedPoint() {
        assertThrows(
                IllegalArgumentException.class,
                () -> MinimumCostToConnectPoints.minimumCost(
                        new int[][] {{0, 1}, {2}}));
    }
}
