package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JumpGameIITest {
    @Test
    void findsMinimumJumpsAcrossGreedyFrontiers() {
        assertEquals(2, JumpGameII.minimumJumps(new int[] {2, 3, 1, 1, 4}));
        assertEquals(2, JumpGameII.minimumJumps(new int[] {2, 3, 0, 1, 4}));
    }

    @Test
    void countsEachRequiredSingleStep() {
        assertEquals(2, JumpGameII.minimumJumps(new int[] {1, 1, 1}));
    }

    @Test
    void handlesSinglePositionAndLargeJump() {
        assertEquals(0, JumpGameII.minimumJumps(new int[] {0}));
        assertEquals(
                1,
                JumpGameII.minimumJumps(
                        new int[] {Integer.MAX_VALUE, 0, 0}));
    }

    @Test
    void returnsNegativeOneWhenEndIsUnreachable() {
        assertEquals(-1, JumpGameII.minimumJumps(new int[] {3, 2, 1, 0, 4}));
        assertEquals(-1, JumpGameII.minimumJumps(new int[] {0, 1}));
    }

    @Test
    void doesNotModifyInput() {
        int[] maximumJumps = {2, 3, 1, 1, 4};
        int[] original = maximumJumps.clone();

        JumpGameII.minimumJumps(maximumJumps);

        assertArrayEquals(original, maximumJumps);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> JumpGameII.minimumJumps(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> JumpGameII.minimumJumps(new int[0]));
        assertThrows(
                IllegalArgumentException.class,
                () -> JumpGameII.minimumJumps(new int[] {1, -1, 0}));
    }
}
