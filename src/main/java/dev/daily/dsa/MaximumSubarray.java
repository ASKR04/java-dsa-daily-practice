package dev.daily.dsa;

import java.util.Objects;

/** Finds the largest sum among all non-empty contiguous subarrays. */
public final class MaximumSubarray {
    private MaximumSubarray() {
    }

    public static long maxSum(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");
        if (numbers.length == 0) {
            throw new IllegalArgumentException("numbers must not be empty");
        }

        long endingHere = numbers[0];
        long best = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            endingHere = Math.max(
                    numbers[index], endingHere + numbers[index]);
            best = Math.max(best, endingHere);
        }

        return best;
    }
}
