package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KokoEatingBananasTest {
    @Test
    void findsMinimumSpeedForStandardCase() {
        int[] piles = {3, 6, 7, 11};

        assertEquals(4, KokoEatingBananas.minEatingSpeed(piles, 8));
    }

    @Test
    void increasesSpeedWhenHoursAreTight() {
        int[] piles = {30, 11, 23, 4, 20};

        assertEquals(30, KokoEatingBananas.minEatingSpeed(piles, 5));
    }

    @Test
    void allowsSlowerSpeedWhenThereAreMoreHours() {
        int[] piles = {30, 11, 23, 4, 20};

        assertEquals(23, KokoEatingBananas.minEatingSpeed(piles, 6));
    }

    @Test
    void handlesSinglePile() {
        int[] piles = {9};

        assertEquals(3, KokoEatingBananas.minEatingSpeed(piles, 3));
    }

    @Test
    void handlesLargePileWithoutOverflowingHourCalculation() {
        int[] piles = {1_000_000_000, 1_000_000_000};

        assertEquals(1_000_000_000, KokoEatingBananas.minEatingSpeed(piles, 2));
    }
}
