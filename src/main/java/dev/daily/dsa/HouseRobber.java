package dev.daily.dsa;

import java.util.Objects;

public final class HouseRobber {
    private HouseRobber() {
    }

    public static long maximumLoot(int[] houses) {
        Objects.requireNonNull(houses, "houses must not be null");

        long twoHousesBack = 0;
        long oneHouseBack = 0;
        for (int money : houses) {
            if (money < 0) {
                throw new IllegalArgumentException(
                        "house values must not be negative");
            }

            long robCurrent = twoHousesBack + money;
            long skipCurrent = oneHouseBack;
            long current = Math.max(robCurrent, skipCurrent);
            twoHousesBack = oneHouseBack;
            oneHouseBack = current;
        }
        return oneHouseBack;
    }
}
