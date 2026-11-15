package dev.daily.dsa;

import java.util.Objects;

/** Finds the largest product among all non-empty contiguous subarrays. */
public final class MaximumProductSubarray {
    private MaximumProductSubarray() {
    }

    public static long maxProduct(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");
        if (numbers.length == 0) {
            throw new IllegalArgumentException("numbers must not be empty");
        }

        long maximumEndingHere = numbers[0];
        long minimumEndingHere = numbers[0];
        long best = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            long value = numbers[index];
            if (value < 0) {
                long swap = maximumEndingHere;
                maximumEndingHere = minimumEndingHere;
                minimumEndingHere = swap;
            }

            maximumEndingHere = Math.max(
                    value, Math.multiplyExact(maximumEndingHere, value));
            minimumEndingHere = Math.min(
                    value, Math.multiplyExact(minimumEndingHere, value));
            best = Math.max(best, maximumEndingHere);
        }

        return best;
    }
}
