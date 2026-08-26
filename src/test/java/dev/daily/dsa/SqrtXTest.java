package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtXTest {
    @Test
    void returnsSameValueForZeroAndOne() {
        assertEquals(0, SqrtX.sqrt(0));
        assertEquals(1, SqrtX.sqrt(1));
    }

    @Test
    void returnsExactSquareRootForPerfectSquare() {
        assertEquals(8, SqrtX.sqrt(64));
    }

    @Test
    void roundsDownForNonPerfectSquare() {
        assertEquals(2, SqrtX.sqrt(8));
    }

    @Test
    void handlesLargeValueWithoutOverflow() {
        assertEquals(46340, SqrtX.sqrt(Integer.MAX_VALUE));
    }

    @Test
    void handlesSmallNonPerfectSquare() {
        assertEquals(1, SqrtX.sqrt(2));
    }
}
