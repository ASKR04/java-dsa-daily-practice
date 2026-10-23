package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RottingOrangesTest {
    @Test
    void findsMinutesForAllOrangesToRot() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        assertEquals(4, RottingOranges.minimumMinutes(grid));
    }

    @Test
    void usesAllInitiallyRottenOrangesAsSources() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 0},
            {1, 1, 2}
        };

        assertEquals(2, RottingOranges.minimumMinutes(grid));
    }

    @Test
    void returnsMinusOneWhenFreshOrangeIsIsolated() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };

        assertEquals(-1, RottingOranges.minimumMinutes(grid));
    }

    @Test
    void returnsZeroWhenThereAreNoFreshOranges() {
        assertEquals(0, RottingOranges.minimumMinutes(new int[][] {{0, 2}}));
        assertEquals(0, RottingOranges.minimumMinutes(new int[0][]));
    }

    @Test
    void doesNotModifyInputGrid() {
        int[][] grid = {{2, 1}, {1, 1}};
        int[][] original = {grid[0].clone(), grid[1].clone()};

        RottingOranges.minimumMinutes(grid);

        assertArrayEquals(original[0], grid[0]);
        assertArrayEquals(original[1], grid[1]);
    }

    @Test
    void rejectsJaggedGrid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RottingOranges.minimumMinutes(new int[][] {{2, 1}, {1}}));
    }

    @Test
    void rejectsInvalidCellValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RottingOranges.minimumMinutes(new int[][] {{2, 3}}));
    }
}
