package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LastStoneWeightTest {
    @Test
    void returnsRemainingStoneAfterRepeatedSmashes() {
        assertEquals(1, LastStoneWeight.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    }

    @Test
    void removesEqualWeightStones() {
        assertEquals(0, LastStoneWeight.lastStoneWeight(new int[] {2, 2}));
    }

    @Test
    void handlesSeveralSmashRounds() {
        assertEquals(2, LastStoneWeight.lastStoneWeight(new int[] {10, 4, 2, 10}));
    }

    @Test
    void returnsOnlyStone() {
        assertEquals(5, LastStoneWeight.lastStoneWeight(new int[] {5}));
    }

    @Test
    void returnsZeroForEmptyInput() {
        assertEquals(0, LastStoneWeight.lastStoneWeight(new int[0]));
    }

    @Test
    void doesNotModifyInputArray() {
        int[] stones = {3, 7, 2};
        int[] original = stones.clone();

        LastStoneWeight.lastStoneWeight(stones);

        assertArrayEquals(original, stones);
    }

    @Test
    void rejectsNegativeWeight() {
        assertThrows(
                IllegalArgumentException.class,
                () -> LastStoneWeight.lastStoneWeight(new int[] {2, -1}));
    }
}
