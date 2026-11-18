package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GasStationTest {
    @Test
    void findsStartAfterSkippingFailedPrefixes() {
        assertEquals(
                3,
                GasStation.findStart(
                        new int[] {1, 2, 3, 4, 5},
                        new int[] {3, 4, 5, 1, 2}));
    }

    @Test
    void returnsNegativeOneWhenTotalGasIsInsufficient() {
        assertEquals(
                -1,
                GasStation.findStart(
                        new int[] {2, 3, 4},
                        new int[] {3, 4, 3}));
    }

    @Test
    void handlesSingleStationAndZeroBalances() {
        assertEquals(0, GasStation.findStart(new int[] {5}, new int[] {4}));
        assertEquals(
                0,
                GasStation.findStart(
                        new int[] {0, 0},
                        new int[] {0, 0}));
    }

    @Test
    void doesNotModifyInputs() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int[] originalGas = gas.clone();
        int[] originalCost = cost.clone();

        GasStation.findStart(gas, cost);

        assertArrayEquals(originalGas, gas);
        assertArrayEquals(originalCost, cost);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> GasStation.findStart(null, new int[] {1}));
        assertThrows(
                NullPointerException.class,
                () -> GasStation.findStart(new int[] {1}, null));
        assertThrows(
                IllegalArgumentException.class,
                () -> GasStation.findStart(new int[0], new int[0]));
        assertThrows(
                IllegalArgumentException.class,
                () -> GasStation.findStart(
                        new int[] {1, 2}, new int[] {1}));
        assertThrows(
                IllegalArgumentException.class,
                () -> GasStation.findStart(
                        new int[] {1, -1}, new int[] {1, 1}));
    }
}
