package dev.daily.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class CoinChange {
    private CoinChange() {
    }

    public static int minimumCoins(int[] coins, int amount) {
        Objects.requireNonNull(coins, "coins must not be null");
        if (amount < 0) {
            throw new IllegalArgumentException("amount must not be negative");
        }
        validateCoins(coins);

        int unreachable = amount + 1;
        int[] minimum = new int[amount + 1];
        Arrays.fill(minimum, unreachable);
        minimum[0] = 0;

        for (int currentAmount = 1;
                currentAmount <= amount;
                currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    minimum[currentAmount] = Math.min(
                            minimum[currentAmount],
                            minimum[currentAmount - coin] + 1);
                }
            }
        }

        return minimum[amount] == unreachable ? -1 : minimum[amount];
    }

    private static void validateCoins(int[] coins) {
        Set<Integer> seen = new HashSet<>();
        for (int coin : coins) {
            if (coin <= 0) {
                throw new IllegalArgumentException(
                        "coin values must be positive");
            }
            if (!seen.add(coin)) {
                throw new IllegalArgumentException(
                        "coin values must be distinct");
            }
        }
    }
}
