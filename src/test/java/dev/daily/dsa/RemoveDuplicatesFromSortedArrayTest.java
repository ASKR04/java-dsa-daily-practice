package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {
    @Test
    void removesDuplicatesAndReturnsUniqueLength() {
        int[] nums = { 1, 1, 2 };

        int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        assertEquals(2, length);
        assertArrayEquals(new int[] { 1, 2 }, Arrays.copyOf(nums, length));
    }

    @Test
    void preservesSortedUniqueValuesAcrossRepeatedGroups() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        assertEquals(5, length);
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, Arrays.copyOf(nums, length));
    }

    @Test
    void returnsZeroForEmptyArray() {
        int[] nums = {};

        int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        assertEquals(0, length);
    }

    @Test
    void returnsOneWhenAllValuesAreIdentical() {
        int[] nums = { 7, 7, 7 };

        int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);

        assertEquals(1, length);
        assertArrayEquals(new int[] { 7 }, Arrays.copyOf(nums, length));
    }
}

