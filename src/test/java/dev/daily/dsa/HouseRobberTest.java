package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HouseRobberTest {
    @Test
    void choosesBestNonAdjacentHouses() {
        assertEquals(4, HouseRobber.maximumLoot(new int[] {1, 2, 3, 1}));
        assertEquals(12, HouseRobber.maximumLoot(new int[] {2, 7, 9, 3, 1}));
    }

    @Test
    void handlesEmptyAndSingleHouseStreets() {
        assertEquals(0, HouseRobber.maximumLoot(new int[0]));
        assertEquals(8, HouseRobber.maximumLoot(new int[] {8}));
    }

    @Test
    void handlesZeroValueHouses() {
        assertEquals(0, HouseRobber.maximumLoot(new int[] {0, 0, 0}));
    }

    @Test
    void usesLongForLargeCombinedLoot() {
        assertEquals(
                4_294_967_294L,
                HouseRobber.maximumLoot(new int[] {
                    Integer.MAX_VALUE,
                    0,
                    Integer.MAX_VALUE
                }));
    }

    @Test
    void doesNotModifyHouses() {
        int[] houses = {4, 1, 2, 9};
        int[] original = houses.clone();

        HouseRobber.maximumLoot(houses);

        assertArrayEquals(original, houses);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> HouseRobber.maximumLoot(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> HouseRobber.maximumLoot(new int[] {2, -1, 3}));
    }
}
