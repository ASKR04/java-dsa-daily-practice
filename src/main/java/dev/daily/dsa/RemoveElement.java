package dev.daily.dsa;

public final class RemoveElement {
    private RemoveElement() {
    }

    public static int remove(int[] nums, int val) {
        int write = 0;

        for (int num : nums) {
            if (num != val) {
                nums[write] = num;
                write++;
            }
        }

        return write;
    }
}

