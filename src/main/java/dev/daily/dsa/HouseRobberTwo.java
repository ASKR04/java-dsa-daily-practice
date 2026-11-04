package dev.daily.dsa;

import java.util.Objects;

public final class HouseRobberTwo {
    private HouseRobberTwo() {
    }

    public static long maximumLoot(int[] houses) {
        Objects.requireNonNull(houses, "houses must not be null");
        for (int money : houses) {
            if (money < 0) {
                throw new IllegalArgumentException(
                        "house values must not be negative");
            }
        }
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }

        long excludeLast = maximumLootInRange(houses, 0, houses.length - 2);
        long excludeFirst = maximumLootInRange(houses, 1, houses.length - 1);
        return Math.max(excludeLast, excludeFirst);
    }

    private static long maximumLootInRange(
            int[] houses,
            int start,
            int end) {
        long twoHousesBack = 0;
        long oneHouseBack = 0;
        for (int index = start; index <= end; index++) {
            long robCurrent = twoHousesBack + houses[index];
            long skipCurrent = oneHouseBack;
            long current = Math.max(robCurrent, skipCurrent);
            twoHousesBack = oneHouseBack;
            oneHouseBack = current;
        }
        return oneHouseBack;
    }
}
