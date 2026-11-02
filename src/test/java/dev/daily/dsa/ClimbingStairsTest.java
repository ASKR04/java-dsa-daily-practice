package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ClimbingStairsTest {
    @Test
    void countsSmallStaircases() {
        assertEquals(1, ClimbingStairs.countWays(0));
        assertEquals(1, ClimbingStairs.countWays(1));
        assertEquals(2, ClimbingStairs.countWays(2));
        assertEquals(3, ClimbingStairs.countWays(3));
        assertEquals(8, ClimbingStairs.countWays(5));
    }

    @Test
    void countsLargerStaircase() {
        assertEquals(1_836_311_903L, ClimbingStairs.countWays(45));
    }

    @Test
    void supportsLargestResultThatFitsInLong() {
        assertEquals(
                7_540_113_804_746_346_429L,
                ClimbingStairs.countWays(91));
    }

    @Test
    void rejectsNegativeSteps() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ClimbingStairs.countWays(-1));
    }

    @Test
    void rejectsResultThatWouldOverflowLong() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ClimbingStairs.countWays(92));
    }
}
