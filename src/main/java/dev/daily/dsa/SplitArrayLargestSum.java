package dev.daily.dsa;

public final class SplitArrayLargestSum {
    private SplitArrayLargestSum() {
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int answer = right;

        while (left <= right) {
            int largestAllowedSum = left + (right - left) / 2;

            if (canSplit(nums, k, largestAllowedSum)) {
                answer = largestAllowedSum;
                right = largestAllowedSum - 1;
            } else {
                left = largestAllowedSum + 1;
            }
        }

        return answer;
    }

    private static boolean canSplit(int[] nums, int k, int largestAllowedSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > largestAllowedSum) {
                subarrays++;
                currentSum = 0;
            }

            currentSum += num;

            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }
}
