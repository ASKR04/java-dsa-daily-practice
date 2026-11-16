package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JumpGameTest {
    @Test
    void reachesEndThroughBestAvailableFrontier() {
        assertTrue(JumpGame.canReachEnd(new int[] {2, 3, 1, 1, 4}));
    }

    @Test
    void detectsUnreachablePositionAfterZero() {
        assertFalse(JumpGame.canReachEnd(new int[] {3, 2, 1, 0, 4}));
    }

    @Test
    void handlesSinglePositionAndLargeJump() {
        assertTrue(JumpGame.canReachEnd(new int[] {0}));
        assertTrue(JumpGame.canReachEnd(
                new int[] {Integer.MAX_VALUE, 0, 0}));
    }

    @Test
    void doesNotModifyInput() {
        int[] maximumJumps = {2, 0, 1};
        int[] original = maximumJumps.clone();

        JumpGame.canReachEnd(maximumJumps);

        assertArrayEquals(original, maximumJumps);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> JumpGame.canReachEnd(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> JumpGame.canReachEnd(new int[0]));
        assertThrows(
                IllegalArgumentException.class,
                () -> JumpGame.canReachEnd(new int[] {1, -1, 0}));
    }
}
