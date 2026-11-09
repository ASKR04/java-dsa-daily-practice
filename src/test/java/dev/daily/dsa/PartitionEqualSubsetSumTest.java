package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PartitionEqualSubsetSumTest {
    @Test
    void findsEqualPartition() {
        assertTrue(
                PartitionEqualSubsetSum.canPartition(
                        new int[] {1, 5, 11, 5}));
    }

    @Test
    void rejectsArrayWithoutEqualPartition() {
        assertFalse(
                PartitionEqualSubsetSum.canPartition(
                        new int[] {1, 2, 3, 5}));
    }

    @Test
    void handlesEmptyAndZeroValueInputs() {
        assertTrue(PartitionEqualSubsetSum.canPartition(new int[0]));
        assertTrue(
                PartitionEqualSubsetSum.canPartition(new int[] {0, 0, 0}));
    }

    @Test
    void usesLongForTotalSum() {
        assertTrue(
                PartitionEqualSubsetSum.canPartition(
                        new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {1, 5, 11, 5};
        int[] original = numbers.clone();

        PartitionEqualSubsetSum.canPartition(numbers);

        assertArrayEquals(original, numbers);
    }

    @Test
    void rejectsInvalidInputs() {
        assertThrows(
                NullPointerException.class,
                () -> PartitionEqualSubsetSum.canPartition(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> PartitionEqualSubsetSum.canPartition(
                        new int[] {1, -1, 2}));
    }
}
