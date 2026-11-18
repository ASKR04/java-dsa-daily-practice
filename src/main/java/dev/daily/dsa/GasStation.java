package dev.daily.dsa;

import java.util.Objects;

/** Finds a station from which a complete circular route is possible. */
public final class GasStation {
    private GasStation() {
    }

    public static int findStart(int[] gas, int[] cost) {
        Objects.requireNonNull(gas, "gas must not be null");
        Objects.requireNonNull(cost, "cost must not be null");
        if (gas.length == 0 || gas.length != cost.length) {
            throw new IllegalArgumentException(
                    "gas and cost must have the same non-zero length");
        }

        for (int index = 0; index < gas.length; index++) {
            if (gas[index] < 0 || cost[index] < 0) {
                throw new IllegalArgumentException(
                        "gas and cost must not contain negative values");
            }
        }

        long totalBalance = 0;
        long currentBalance = 0;
        int candidate = 0;

        for (int index = 0; index < gas.length; index++) {
            long balance = (long) gas[index] - cost[index];
            totalBalance += balance;
            currentBalance += balance;

            if (currentBalance < 0) {
                candidate = index + 1;
                currentBalance = 0;
            }
        }

        return totalBalance >= 0 ? candidate : -1;
    }
}
