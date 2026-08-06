package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {
    @Test
    void findsPairWhenDistinctValuesAddToTarget() {
        assertArrayEquals(new int[] { 0, 1 }, TwoSum.findPair(new int[] { 2, 7, 11, 15 }, 9));
    }

    @Test
    void findsPairWhenDuplicateValuesAreNeeded() {
        assertArrayEquals(new int[] { 0, 1 }, TwoSum.findPair(new int[] { 3, 3 }, 6));
    }

    @Test
    void returnsSentinelWhenNoPairExists() {
        assertArrayEquals(new int[] { -1, -1 }, TwoSum.findPair(new int[] { 1, 2, 4 }, 10));
    }
}

