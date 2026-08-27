package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FindPeakElementTest {
    @Test
    void findsOnlyElementAsPeak() {
        int[] nums = {7};

        assertPeak(nums, FindPeakElement.findPeak(nums));
    }

    @Test
    void findsPeakInStrictlyIncreasingArray() {
        int[] nums = {1, 2, 3, 4};

        assertPeak(nums, FindPeakElement.findPeak(nums));
    }

    @Test
    void findsPeakInStrictlyDecreasingArray() {
        int[] nums = {4, 3, 2, 1};

        assertPeak(nums, FindPeakElement.findPeak(nums));
    }

    @Test
    void findsPeakInsideArray() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        assertPeak(nums, FindPeakElement.findPeak(nums));
    }

    private static void assertPeak(int[] nums, int index) {
        boolean greaterThanLeft = index == 0 || nums[index] > nums[index - 1];
        boolean greaterThanRight = index == nums.length - 1 || nums[index] > nums[index + 1];

        assertTrue(greaterThanLeft && greaterThanRight);
    }
}
