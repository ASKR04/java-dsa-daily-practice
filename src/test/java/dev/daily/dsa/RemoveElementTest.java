package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {
    @Test
    void removesAllOccurrencesOfTargetValue() {
        int[] nums = { 3, 2, 2, 3 };

        int length = RemoveElement.remove(nums, 3);

        assertEquals(2, length);
        assertArrayEquals(new int[] { 2, 2 }, Arrays.copyOf(nums, length));
    }

    @Test
    void preservesRemainingValuesInScanOrder() {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };

        int length = RemoveElement.remove(nums, 2);

        assertEquals(5, length);
        assertArrayEquals(new int[] { 0, 1, 3, 0, 4 }, Arrays.copyOf(nums, length));
    }

    @Test
    void returnsOriginalLengthWhenTargetDoesNotAppear() {
        int[] nums = { 1, 2, 3 };

        int length = RemoveElement.remove(nums, 9);

        assertEquals(3, length);
        assertArrayEquals(new int[] { 1, 2, 3 }, Arrays.copyOf(nums, length));
    }

    @Test
    void returnsZeroWhenEveryValueIsRemoved() {
        int[] nums = { 5, 5, 5 };

        int length = RemoveElement.remove(nums, 5);

        assertEquals(0, length);
    }
}

