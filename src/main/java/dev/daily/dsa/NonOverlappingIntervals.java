package dev.daily.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/** Finds the fewest intervals to remove so the remainder do not overlap. */
public final class NonOverlappingIntervals {
    private NonOverlappingIntervals() {
    }

    public static int minimumRemovals(int[][] intervals) {
        Objects.requireNonNull(intervals, "intervals must not be null");
        if (intervals.length == 0) {
            return 0;
        }

        int[][] sorted = new int[intervals.length][2];
        for (int index = 0; index < intervals.length; index++) {
            int[] interval = Objects.requireNonNull(
                    intervals[index], "intervals must not contain null");
            if (interval.length != 2 || interval[0] >= interval[1]) {
                throw new IllegalArgumentException(
                        "each interval must contain a start smaller than its end");
            }
            sorted[index] = interval.clone();
        }

        Arrays.sort(
                sorted,
                Comparator.comparingInt((int[] interval) -> interval[1])
                        .thenComparingInt(interval -> interval[0]));

        int removals = 0;
        int previousEnd = sorted[0][1];
        for (int index = 1; index < sorted.length; index++) {
            if (sorted[index][0] < previousEnd) {
                removals++;
            } else {
                previousEnd = sorted[index][1];
            }
        }

        return removals;
    }
}
