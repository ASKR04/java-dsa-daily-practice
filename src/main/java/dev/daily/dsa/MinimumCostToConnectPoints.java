package dev.daily.dsa;

import java.util.Arrays;
import java.util.Objects;

public final class MinimumCostToConnectPoints {
    private MinimumCostToConnectPoints() {
    }

    public static int minimumCost(int[][] points) {
        Objects.requireNonNull(points, "points must not be null");
        validatePoints(points);
        if (points.length <= 1) {
            return 0;
        }

        boolean[] inTree = new boolean[points.length];
        long[] minimumConnectionCosts = new long[points.length];
        Arrays.fill(minimumConnectionCosts, Long.MAX_VALUE);
        minimumConnectionCosts[0] = 0;

        long totalCost = 0;
        for (int addedPoints = 0; addedPoints < points.length; addedPoints++) {
            int nextPoint = findClosestPoint(inTree, minimumConnectionCosts);
            inTree[nextPoint] = true;
            totalCost += minimumConnectionCosts[nextPoint];

            for (int candidate = 0; candidate < points.length; candidate++) {
                if (!inTree[candidate]) {
                    long connectionCost = manhattanDistance(
                            points[nextPoint], points[candidate]);
                    minimumConnectionCosts[candidate] = Math.min(
                            minimumConnectionCosts[candidate], connectionCost);
                }
            }
        }

        return Math.toIntExact(totalCost);
    }

    private static int findClosestPoint(
            boolean[] inTree,
            long[] minimumConnectionCosts) {
        int closestPoint = -1;
        for (int point = 0; point < inTree.length; point++) {
            if (!inTree[point]
                    && (closestPoint == -1
                            || minimumConnectionCosts[point]
                                    < minimumConnectionCosts[closestPoint])) {
                closestPoint = point;
            }
        }
        return closestPoint;
    }

    private static long manhattanDistance(int[] first, int[] second) {
        return Math.abs((long) first[0] - second[0])
                + Math.abs((long) first[1] - second[1]);
    }

    private static void validatePoints(int[][] points) {
        for (int[] point : points) {
            if (point == null || point.length != 2) {
                throw new IllegalArgumentException(
                        "each point must contain x and y coordinates");
            }
        }
    }
}
