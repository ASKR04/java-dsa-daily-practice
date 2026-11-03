package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MinCostClimbingStairsTest {
    @Test
    void choosesCheapestStartingStep() {
        assertEquals(
                15,
                MinCostClimbingStairs.minimumCost(new int[] {10, 15, 20}));
    }

    @Test
    void findsMinimumAcrossLongerStaircase() {
        int[] costs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        assertEquals(6, MinCostClimbingStairs.minimumCost(costs));
    }

    @Test
    void handlesTwoStepsAndZeroCosts() {
        assertEquals(
                3,
                MinCostClimbingStairs.minimumCost(new int[] {8, 3}));
        assertEquals(
                0,
                MinCostClimbingStairs.minimumCost(new int[] {0, 0, 0}));
    }

    @Test
    void usesLongForLargeTotalCosts() {
        int[] costs = {
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE
        };

        assertEquals(
                4_294_967_294L,
                MinCostClimbingStairs.minimumCost(costs));
    }

    @Test
    void doesNotModifyCosts() {
        int[] costs = {4, 1, 7, 2};
        int[] original = costs.clone();

        MinCostClimbingStairs.minimumCost(costs);

        assertArrayEquals(original, costs);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> MinCostClimbingStairs.minimumCost(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> MinCostClimbingStairs.minimumCost(new int[] {5}));
        assertThrows(
                IllegalArgumentException.class,
                () -> MinCostClimbingStairs.minimumCost(new int[] {1, -2}));
    }
}
