package dev.daily.dsa;

public final class MoveZeroes {
    private MoveZeroes() {
    }

    public static void move(int[] nums) {
        int write = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[write] = num;
                write++;
            }
        }

        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }
}

