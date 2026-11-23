package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Inserts and merges an interval into sorted non-overlapping intervals. */
public final class InsertInterval {
    private InsertInterval() {
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Objects.requireNonNull(intervals, "intervals must not be null");
        validateInterval(newInterval, "newInterval");

        int previousEnd = Integer.MIN_VALUE;
        for (int index = 0; index < intervals.length; index++) {
            validateInterval(intervals[index], "intervals must be valid");
            if (index > 0 && intervals[index][0] <= previousEnd) {
                throw new IllegalArgumentException(
                        "intervals must be sorted and non-overlapping");
            }
            previousEnd = intervals[index][1];
        }

        List<int[]> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.length
                && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index].clone());
            index++;
        }

        int mergedStart = newInterval[0];
        int mergedEnd = newInterval[1];
        while (index < intervals.length
                && intervals[index][0] <= mergedEnd) {
            mergedStart = Math.min(mergedStart, intervals[index][0]);
            mergedEnd = Math.max(mergedEnd, intervals[index][1]);
            index++;
        }
        result.add(new int[] {mergedStart, mergedEnd});

        while (index < intervals.length) {
            result.add(intervals[index].clone());
            index++;
        }

        return result.toArray(int[][]::new);
    }

    private static void validateInterval(int[] interval, String name) {
        Objects.requireNonNull(interval, name + " must not be null");
        if (interval.length != 2 || interval[0] > interval[1]) {
            throw new IllegalArgumentException(
                    name + " must contain a start no greater than its end");
        }
    }
}
