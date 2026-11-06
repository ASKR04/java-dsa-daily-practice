package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UniquePathsTest {
    @Test
    void countsPathsAcrossRectangularGrids() {
        assertEquals(28, UniquePaths.count(3, 7));
        assertEquals(3, UniquePaths.count(3, 2));
        assertEquals(28, UniquePaths.count(7, 3));
    }

    @Test
    void handlesSingleRowOrColumn() {
        assertEquals(1, UniquePaths.count(1, 8));
        assertEquals(1, UniquePaths.count(9, 1));
        assertEquals(1, UniquePaths.count(1, 1));
    }

    @Test
    void countsLargerGridUsingLong() {
        assertEquals(35_345_263_800L, UniquePaths.count(20, 20));
    }

    @Test
    void rejectsInvalidDimensions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> UniquePaths.count(0, 4));
        assertThrows(
                IllegalArgumentException.class,
                () -> UniquePaths.count(4, -1));
    }

    @Test
    void detectsLongOverflow() {
        assertThrows(
                ArithmeticException.class,
                () -> UniquePaths.count(35, 35));
    }
}
