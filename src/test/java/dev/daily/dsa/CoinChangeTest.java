package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CoinChangeTest {
    @Test
    void findsMinimumNumberOfCoins() {
        assertEquals(3, CoinChange.minimumCoins(new int[] {1, 2, 5}, 11));
        assertEquals(2, CoinChange.minimumCoins(new int[] {5, 3, 1}, 6));
    }

    @Test
    void returnsMinusOneWhenAmountCannotBeFormed() {
        assertEquals(-1, CoinChange.minimumCoins(new int[] {2}, 3));
        assertEquals(-1, CoinChange.minimumCoins(new int[0], 7));
    }

    @Test
    void returnsZeroForZeroAmount() {
        assertEquals(0, CoinChange.minimumCoins(new int[] {2, 5}, 0));
        assertEquals(0, CoinChange.minimumCoins(new int[0], 0));
    }

    @Test
    void doesNotModifyCoins() {
        int[] coins = {5, 1, 2};
        int[] original = coins.clone();

        CoinChange.minimumCoins(coins, 8);

        assertArrayEquals(original, coins);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> CoinChange.minimumCoins(null, 7));
        assertThrows(
                IllegalArgumentException.class,
                () -> CoinChange.minimumCoins(new int[] {1, 2}, -1));
        assertThrows(
                IllegalArgumentException.class,
                () -> CoinChange.minimumCoins(new int[] {0, 2}, 7));
        assertThrows(
                IllegalArgumentException.class,
                () -> CoinChange.minimumCoins(new int[] {2, 2}, 7));
    }
}
