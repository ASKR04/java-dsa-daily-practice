package dev.daily.dsa;

import java.util.Objects;

/** Finds the minimum jumps needed to reach the final array index. */
public final class JumpGameII {
    private JumpGameII() {
    }

    public static int minimumJumps(int[] maximumJumps) {
        Objects.requireNonNull(maximumJumps, "maximumJumps must not be null");
        if (maximumJumps.length == 0) {
            throw new IllegalArgumentException("maximumJumps must not be empty");
        }

        for (int jump : maximumJumps) {
            if (jump < 0) {
                throw new IllegalArgumentException(
                        "maximumJumps must not contain negative values");
            }
        }

        int jumps = 0;
        long currentJumpEnd = 0;
        long farthestReachable = 0;

        for (int index = 0; index < maximumJumps.length - 1; index++) {
            if (index > farthestReachable) {
                return -1;
            }

            farthestReachable = Math.max(
                    farthestReachable, (long) index + maximumJumps[index]);
            if (index == currentJumpEnd) {
                if (farthestReachable == currentJumpEnd) {
                    return -1;
                }
                jumps++;
                currentJumpEnd = farthestReachable;
                if (currentJumpEnd >= maximumJumps.length - 1L) {
                    return jumps;
                }
            }
        }

        return jumps;
    }
}
