package dev.daily.dsa;

public final class ClimbingStairs {
    private static final int MAX_STEPS_WITH_LONG_RESULT = 91;

    private ClimbingStairs() {
    }

    public static long countWays(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("steps must not be negative");
        }
        if (steps > MAX_STEPS_WITH_LONG_RESULT) {
            throw new IllegalArgumentException("result exceeds long range");
        }

        long previous = 1;
        long current = 1;
        for (int step = 2; step <= steps; step++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
