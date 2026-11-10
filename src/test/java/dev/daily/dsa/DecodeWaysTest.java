package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DecodeWaysTest {
    @Test
    void countsSingleAndDoubleDigitChoices() {
        assertEquals(2, DecodeWays.count("12"));
        assertEquals(3, DecodeWays.count("226"));
    }

    @Test
    void handlesZerosThatMustBelongToValidPairs() {
        assertEquals(0, DecodeWays.count("06"));
        assertEquals(1, DecodeWays.count("10"));
        assertEquals(1, DecodeWays.count("2101"));
        assertEquals(2, DecodeWays.count("11106"));
    }

    @Test
    void handlesEmptyAndInvalidInputs() {
        assertEquals(0, DecodeWays.count(""));
        assertThrows(NullPointerException.class, () -> DecodeWays.count(null));
        assertThrows(IllegalArgumentException.class, () -> DecodeWays.count("12a"));
    }

    @Test
    void rejectsResultsThatOverflowLong() {
        assertThrows(ArithmeticException.class, () -> DecodeWays.count("1".repeat(100)));
    }
}
