package dev.daily.dsa;

import java.util.Objects;

/** Determines whether jumps from the first index can reach the final index. */
public final class JumpGame {
    private JumpGame() {
    }

    public static boolean canReachEnd(int[] maximumJumps) {
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

        long farthestReachable = 0;
        for (int index = 0;
                index < maximumJumps.length && index <= farthestReachable;
                index++) {
            farthestReachable = Math.max(
                    farthestReachable, (long) index + maximumJumps[index]);
            if (farthestReachable >= maximumJumps.length - 1L) {
                return true;
            }
        }

        return false;
    }
}
