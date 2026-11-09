package dev.daily.dsa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class PartitionEqualSubsetSum {
    private PartitionEqualSubsetSum() {
    }

    public static boolean canPartition(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        long total = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        "numbers must not contain negative values");
            }
            total += number;
        }
        if ((total & 1) == 1) {
            return false;
        }

        long target = total / 2;
        Set<Long> reachable = new HashSet<>();
        reachable.add(0L);
        for (int number : numbers) {
            Set<Long> next = new HashSet<>(reachable);
            for (long sum : reachable) {
                long candidate = sum + number;
                if (candidate == target) {
                    return true;
                }
                if (candidate < target) {
                    next.add(candidate);
                }
            }
            reachable = next;
        }
        return reachable.contains(target);
    }
}
