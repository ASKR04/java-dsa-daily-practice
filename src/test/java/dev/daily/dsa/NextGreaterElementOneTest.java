package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextGreaterElementOneTest {
    @Test
    void findsNextGreaterValuesForSubset() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        assertArrayEquals(
                new int[] {-1, 3, -1},
                NextGreaterElementOne.nextGreaterElement(nums1, nums2)
        );
    }

    @Test
    void resolvesMultipleValuesWhenCurrentValueIsGreater() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        assertArrayEquals(
                new int[] {3, -1},
                NextGreaterElementOne.nextGreaterElement(nums1, nums2)
        );
    }

    @Test
    void handlesValuesWithNoGreaterElementToTheRight() {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {3, 2, 1};

        assertArrayEquals(
                new int[] {-1, -1, -1},
                NextGreaterElementOne.nextGreaterElement(nums1, nums2)
        );
    }

    @Test
    void handlesSingleElementInput() {
        int[] nums1 = {7};
        int[] nums2 = {7};

        assertArrayEquals(
                new int[] {-1},
                NextGreaterElementOne.nextGreaterElement(nums1, nums2)
        );
    }
}
