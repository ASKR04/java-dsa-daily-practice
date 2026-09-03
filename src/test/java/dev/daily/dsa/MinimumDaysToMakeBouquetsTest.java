package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDaysToMakeBouquetsTest {
    @Test
    void findsMinimumDayForSingleFlowerBouquets() {
        int[] bloomDay = {1, 10, 3, 10, 2};

        assertEquals(3, MinimumDaysToMakeBouquets.minDays(bloomDay, 3, 1));
    }

    @Test
    void returnsNegativeOneWhenThereAreNotEnoughFlowers() {
        int[] bloomDay = {1, 10, 3, 10, 2};

        assertEquals(-1, MinimumDaysToMakeBouquets.minDays(bloomDay, 3, 2));
    }

    @Test
    void requiresAdjacentFlowersForBouquets() {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};

        assertEquals(12, MinimumDaysToMakeBouquets.minDays(bloomDay, 2, 3));
    }

    @Test
    void handlesAlreadyGroupedEarlyBlooms() {
        int[] bloomDay = {1, 2, 4, 9, 3, 4, 1};

        assertEquals(4, MinimumDaysToMakeBouquets.minDays(bloomDay, 2, 2));
    }

    @Test
    void handlesLargeRequiredFlowerCountWithoutOverflow() {
        int[] bloomDay = {1, 2, 3};

        assertEquals(-1, MinimumDaysToMakeBouquets.minDays(bloomDay, 1_500_000_000, 2));
    }
}
