package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {
    @Test
    void countsOneConnectedIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        assertEquals(1, NumberOfIslands.countIslands(grid));
    }

    @Test
    void countsSeveralIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        assertEquals(3, NumberOfIslands.countIslands(grid));
    }

    @Test
    void treatsDiagonalLandAsSeparateIslands() {
        char[][] grid = {
            {'1', '0'},
            {'0', '1'}
        };

        assertEquals(2, NumberOfIslands.countIslands(grid));
    }

    @Test
    void returnsZeroForAllWater() {
        assertEquals(
                0,
                NumberOfIslands.countIslands(new char[][] {{'0', '0'}, {'0', '0'}}));
    }

    @Test
    void handlesEmptyGrid() {
        assertEquals(0, NumberOfIslands.countIslands(new char[0][]));
    }

    @Test
    void doesNotModifyGrid() {
        char[][] grid = {{'1', '0'}, {'1', '1'}};
        char[][] original = {grid[0].clone(), grid[1].clone()};

        NumberOfIslands.countIslands(grid);

        assertArrayEquals(original[0], grid[0]);
        assertArrayEquals(original[1], grid[1]);
    }

    @Test
    void rejectsJaggedGrid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberOfIslands.countIslands(
                        new char[][] {{'1', '0'}, {'1'}}));
    }

    @Test
    void rejectsInvalidCell() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberOfIslands.countIslands(new char[][] {{'1', 'x'}}));
    }
}
