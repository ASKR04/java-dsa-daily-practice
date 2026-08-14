package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRecolorsTest {
    @Test
    void returnsMinimumWhiteBlocksInAnyWindow() {
        assertEquals(3, MinimumRecolors.minimumRecolors("WBBWWBBWBW", 7));
    }

    @Test
    void returnsZeroWhenWindowIsAlreadyBlack() {
        assertEquals(0, MinimumRecolors.minimumRecolors("WBWBBBW", 3));
    }

    @Test
    void handlesAllWhiteBlocks() {
        assertEquals(2, MinimumRecolors.minimumRecolors("WWWW", 2));
    }

    @Test
    void handlesWindowEqualToFullString() {
        assertEquals(2, MinimumRecolors.minimumRecolors("BWBW", 4));
    }
}

