package dev.daily.dsa;

import java.util.Arrays;
import java.util.Objects;

/** Counts the minimum rooms needed for half-open meeting intervals. */
public final class MeetingRoomsII {
    private MeetingRoomsII() {
    }

    public static int minimumRooms(int[][] meetings) {
        Objects.requireNonNull(meetings, "meetings must not be null");
        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];
        for (int index = 0; index < meetings.length; index++) {
            int[] meeting = Objects.requireNonNull(meetings[index], "meeting must not be null");
            if (meeting.length != 2 || meeting[0] >= meeting[1]) {
                throw new IllegalArgumentException("each meeting must start before it ends");
            }
            starts[index] = meeting[0];
            ends[index] = meeting[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int ended = 0;
        int peak = 0;
        for (int index = 0; index < starts.length; index++) {
            while (ended < index && ends[ended] <= starts[index]) {
                ended++;
            }
            peak = Math.max(peak, index + 1 - ended);
        }
        return peak;
    }
}
