package dev.daily.dsa;

public final class MergeSortedArray {
    private MergeSortedArray() {
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int write = m + n - 1;

        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[write] = nums1[left];
                left--;
            } else {
                nums1[write] = nums2[right];
                right--;
            }
            write--;
        }
    }
}

