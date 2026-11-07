package dev.daily.dsa;

import java.util.Objects;

public final class LongestIncreasingSubsequence {
    private LongestIncreasingSubsequence() {
    }

    public static int length(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        int[] smallestTail = new int[numbers.length];
        int length = 0;
        for (int number : numbers) {
            int position = firstGreaterThanOrEqual(
                    smallestTail,
                    length,
                    number);
            smallestTail[position] = number;
            if (position == length) {
                length++;
            }
        }
        return length;
    }

    private static int firstGreaterThanOrEqual(
            int[] values,
            int length,
            int target) {
        int left = 0;
        int right = length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (values[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
