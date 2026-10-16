package dev.daily.dsa;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public final class KClosestPointsToOrigin {
    private KClosestPointsToOrigin() {
    }

    public static int[][] kClosest(int[][] points, int k) {
        Objects.requireNonNull(points, "points must not be null");
        if (k < 1 || k > points.length) {
            throw new IllegalArgumentException("k must be between 1 and the number of points");
        }

        Comparator<int[]> closestFirst = (first, second) -> {
            int byDistance = Long.compare(distanceSquared(first), distanceSquared(second));
            if (byDistance != 0) {
                return byDistance;
            }
            int byX = Integer.compare(first[0], second[0]);
            return byX != 0 ? byX : Integer.compare(first[1], second[1]);
        };

        PriorityQueue<int[]> closestPoints =
                new PriorityQueue<>(closestFirst.reversed());
        for (int[] point : points) {
            validatePoint(point);
            closestPoints.offer(point);
            if (closestPoints.size() > k) {
                closestPoints.remove();
            }
        }

        int[][] result = new int[k][2];
        for (int index = k - 1; index >= 0; index--) {
            int[] point = closestPoints.remove();
            result[index][0] = point[0];
            result[index][1] = point[1];
        }
        return result;
    }

    private static long distanceSquared(int[] point) {
        long x = point[0];
        long y = point[1];
        return x * x + y * y;
    }

    private static void validatePoint(int[] point) {
        if (point == null || point.length != 2) {
            throw new IllegalArgumentException("each point must contain exactly two coordinates");
        }
    }
}
