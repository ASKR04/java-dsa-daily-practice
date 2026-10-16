package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class KClosestPointsToOriginTest {
    @Test
    void returnsClosestPoint() {
        assertArrayEquals(
                new int[][] {{-2, 2}},
                KClosestPointsToOrigin.kClosest(new int[][] {{1, 3}, {-2, 2}}, 1));
    }

    @Test
    void returnsKClosestInDistanceOrder() {
        assertArrayEquals(
                new int[][] {{3, 3}, {-2, 4}},
                KClosestPointsToOrigin.kClosest(
                        new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2));
    }

    @Test
    void ordersDistanceTiesByCoordinates() {
        assertArrayEquals(
                new int[][] {{-1, 0}, {0, -1}, {0, 1}},
                KClosestPointsToOrigin.kClosest(
                        new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}, 3));
    }

    @Test
    void usesLongDistanceArithmetic() {
        assertArrayEquals(
                new int[][] {{1, 1}},
                KClosestPointsToOrigin.kClosest(
                        new int[][] {{50_000, 50_000}, {1, 1}}, 1));
    }

    @Test
    void returnsCopiesOfSelectedPoints() {
        int[][] points = {{1, 1}, {2, 2}};

        int[][] result = KClosestPointsToOrigin.kClosest(points, 1);
        result[0][0] = 99;

        assertArrayEquals(new int[] {1, 1}, points[0]);
    }

    @Test
    void rejectsInvalidK() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KClosestPointsToOrigin.kClosest(new int[][] {{1, 2}}, 0));
        assertThrows(
                IllegalArgumentException.class,
                () -> KClosestPointsToOrigin.kClosest(new int[][] {{1, 2}}, 2));
    }

    @Test
    void rejectsMalformedPoint() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KClosestPointsToOrigin.kClosest(new int[][] {{1}}, 1));
    }
}
