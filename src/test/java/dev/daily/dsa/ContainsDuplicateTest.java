package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {
    @Test
    void returnsTrueWhenAnyValueRepeats() {
        assertTrue(ContainsDuplicate.hasDuplicate(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    void returnsFalseWhenAllValuesAreDistinct() {
        assertFalse(ContainsDuplicate.hasDuplicate(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    void returnsTrueWhenNegativeValueRepeats() {
        assertTrue(ContainsDuplicate.hasDuplicate(new int[] { -1, 4, 0, -1 }));
    }

    @Test
    void returnsFalseForSingleElementArray() {
        assertFalse(ContainsDuplicate.hasDuplicate(new int[] { 7 }));
    }
}

