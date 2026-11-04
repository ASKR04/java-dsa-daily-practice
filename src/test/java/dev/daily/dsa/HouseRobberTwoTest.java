package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HouseRobberTwoTest {
    @Test
    void respectsFirstAndLastHouseConflict() {
        assertEquals(3, HouseRobberTwo.maximumLoot(new int[] {2, 3, 2}));
        assertEquals(4, HouseRobberTwo.maximumLoot(new int[] {1, 2, 3, 1}));
    }

    @Test
    void choosesBestSideOfShortCircle() {
        assertEquals(3, HouseRobberTwo.maximumLoot(new int[] {1, 2, 3}));
        assertEquals(9, HouseRobberTwo.maximumLoot(new int[] {9, 4}));
    }

    @Test
    void handlesEmptyAndSingleHouseCircles() {
        assertEquals(0, HouseRobberTwo.maximumLoot(new int[0]));
        assertEquals(8, HouseRobberTwo.maximumLoot(new int[] {8}));
    }

    @Test
    void usesLongForLargeCombinedLoot() {
        assertEquals(
                4_294_967_294L,
                HouseRobberTwo.maximumLoot(new int[] {
                    0,
                    Integer.MAX_VALUE,
                    0,
                    Integer.MAX_VALUE,
                    0
                }));
    }

    @Test
    void doesNotModifyHouses() {
        int[] houses = {4, 1, 2, 9};
        int[] original = houses.clone();

        HouseRobberTwo.maximumLoot(houses);

        assertArrayEquals(original, houses);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> HouseRobberTwo.maximumLoot(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> HouseRobberTwo.maximumLoot(new int[] {2, -1, 3}));
    }
}
