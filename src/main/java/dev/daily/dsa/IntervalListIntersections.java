package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Finds intersections between two sorted lists of disjoint intervals. */
public final class IntervalListIntersections {
    private IntervalListIntersections() {
    }

    public static int[][] intersect(int[][] first, int[][] second) {
        validateList(first, "first");
        validateList(second, "second");

        List<int[]> intersections = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            int start = Math.max(
                    first[firstIndex][0], second[secondIndex][0]);
            int end = Math.min(
                    first[firstIndex][1], second[secondIndex][1]);
            if (start <= end) {
                intersections.add(new int[] {start, end});
            }

            if (first[firstIndex][1] < second[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return intersections.toArray(int[][]::new);
    }

    private static void validateList(int[][] intervals, String name) {
        Objects.requireNonNull(intervals, name + " must not be null");
        int previousEnd = Integer.MIN_VALUE;
        for (int index = 0; index < intervals.length; index++) {
            int[] interval = Objects.requireNonNull(
                    intervals[index], name + " must not contain null");
            if (interval.length != 2 || interval[0] > interval[1]) {
                throw new IllegalArgumentException(
                        name + " intervals must have valid bounds");
            }
            if (index > 0 && interval[0] <= previousEnd) {
                throw new IllegalArgumentException(
                        name + " must be sorted and non-overlapping");
            }
            previousEnd = interval[1];
        }
    }
}
