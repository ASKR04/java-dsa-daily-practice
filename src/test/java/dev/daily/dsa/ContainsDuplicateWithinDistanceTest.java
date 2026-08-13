package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateWithinDistanceTest {
    @Test
    void returnsTrueWhenDuplicateIsWithinDistance() {
        assertTrue(ContainsDuplicateWithinDistance.hasNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
    }

    @Test
    void returnsFalseWhenDuplicateIsTooFarAway() {
        assertFalse(ContainsDuplicateWithinDistance.hasNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
    }

    @Test
    void returnsFalseWhenKIsZero() {
        assertFalse(ContainsDuplicateWithinDistance.hasNearbyDuplicate(new int[] { 1, 1 }, 0));
    }

    @Test
    void handlesNegativeDuplicateWithinWindow() {
        assertTrue(ContainsDuplicateWithinDistance.hasNearbyDuplicate(new int[] { -1, 4, -1 }, 2));
    }
}

