package dev.daily.dsa;

public final class FindFirstAndLastPosition {
    private FindFirstAndLastPosition() {
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);

        if (first == nums.length || nums[first] != target) {
            return new int[] {-1, -1};
        }

        int afterLast = lowerBound(nums, target + 1);
        return new int[] {first, afterLast - 1};
    }

    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
