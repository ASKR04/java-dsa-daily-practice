package dev.daily.dsa;

import java.util.Objects;

public final class MinCostClimbingStairs {
    private MinCostClimbingStairs() {
    }

    public static long minimumCost(int[] costs) {
        Objects.requireNonNull(costs, "costs must not be null");
        if (costs.length < 2) {
            throw new IllegalArgumentException(
                    "at least two stair costs are required");
        }
        for (int cost : costs) {
            if (cost < 0) {
                throw new IllegalArgumentException(
                        "stair costs must not be negative");
            }
        }

        long twoStepsBack = 0;
        long oneStepBack = 0;
        for (int step = 2; step <= costs.length; step++) {
            long fromPrevious = oneStepBack + costs[step - 1];
            long fromTwoBack = twoStepsBack + costs[step - 2];
            long current = Math.min(fromPrevious, fromTwoBack);
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }
        return oneStepBack;
    }
}
