package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {
    @Test
    void movesZeroesToEndWhilePreservingNonZeroOrder() {
        int[] nums = { 0, 1, 0, 3, 12 };

        MoveZeroes.move(nums);

        assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums);
    }

    @Test
    void leavesArrayWithoutZeroesUnchanged() {
        int[] nums = { 1, 2, 3 };

        MoveZeroes.move(nums);

        assertArrayEquals(new int[] { 1, 2, 3 }, nums);
    }

    @Test
    void keepsAllZeroArrayAsAllZeroes() {
        int[] nums = { 0, 0, 0 };

        MoveZeroes.move(nums);

        assertArrayEquals(new int[] { 0, 0, 0 }, nums);
    }

    @Test
    void handlesZeroesAlreadyAtEnd() {
        int[] nums = { 4, 5, 0, 0 };

        MoveZeroes.move(nums);

        assertArrayEquals(new int[] { 4, 5, 0, 0 }, nums);
    }
}

