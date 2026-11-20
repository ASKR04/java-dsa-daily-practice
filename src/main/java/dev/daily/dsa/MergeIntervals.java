package dev.daily.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/** Combines every group of overlapping closed intervals. */
public final class MergeIntervals {
    private MergeIntervals() {
    }

    public static int[][] merge(int[][] intervals) {
        Objects.requireNonNull(intervals, "intervals must not be null");
        if (intervals.length == 0) {
            return new int[0][];
        }

        int[][] sorted = new int[intervals.length][2];
        for (int index = 0; index < intervals.length; index++) {
            int[] interval = Objects.requireNonNull(
                    intervals[index], "intervals must not contain null");
            if (interval.length != 2 || interval[0] > interval[1]) {
                throw new IllegalArgumentException(
                        "each interval must contain a start no greater than its end");
            }
            sorted[index] = interval.clone();
        }

        Arrays.sort(
                sorted,
                Comparator.comparingInt((int[] interval) -> interval[0])
                        .thenComparingInt(interval -> interval[1]));

        List<int[]> merged = new ArrayList<>();
        int currentStart = sorted[0][0];
        int currentEnd = sorted[0][1];

        for (int index = 1; index < sorted.length; index++) {
            if (sorted[index][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, sorted[index][1]);
            } else {
                merged.add(new int[] {currentStart, currentEnd});
                currentStart = sorted[index][0];
                currentEnd = sorted[index][1];
            }
        }
        merged.add(new int[] {currentStart, currentEnd});

        return merged.toArray(int[][]::new);
    }
}
