package dev.daily.dsa;

public final class SmallestDivisorGivenThreshold {
    private SmallestDivisorGivenThreshold() {
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = max(nums);
        int answer = right;

        while (left <= right) {
            int divisor = left + (right - left) / 2;

            if (sumWithinThreshold(nums, threshold, divisor)) {
                answer = divisor;
                right = divisor - 1;
            } else {
                left = divisor + 1;
            }
        }

        return answer;
    }

    private static boolean sumWithinThreshold(int[] nums, int threshold, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) {
                return false;
            }
        }

        return true;
    }

    private static int max(int[] nums) {
        int maximum = nums[0];

        for (int num : nums) {
            maximum = Math.max(maximum, num);
        }

        return maximum;
    }
}
