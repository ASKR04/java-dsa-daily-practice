package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MeetingRoomsIITest {
    @Test
    void countsPeakOverlapWithoutReorderingInput() {
        int[][] meetings = {{15, 20}, {0, 30}, {5, 10}};
        assertEquals(2, MeetingRoomsII.minimumRooms(meetings));
        assertArrayEquals(new int[][] {{15, 20}, {0, 30}, {5, 10}}, meetings);
    }

    @Test
    void reusesRoomsAtSharedEndpoints() {
        assertEquals(1, MeetingRoomsII.minimumRooms(new int[][] {{0, 5}, {5, 10}}));
        assertEquals(3, MeetingRoomsII.minimumRooms(
                new int[][] {{0, 5}, {0, 5}, {0, 5}, {5, 10}}));
    }

    @Test
    void handlesEmptyInputAndExtremeBounds() {
        assertEquals(0, MeetingRoomsII.minimumRooms(new int[0][]));
        assertEquals(1, MeetingRoomsII.minimumRooms(
                new int[][] {{Integer.MIN_VALUE, 0}, {0, Integer.MAX_VALUE}}));
    }

    @Test
    void rejectsInvalidBoundsAndNullRows() {
        assertThrows(IllegalArgumentException.class,
                () -> MeetingRoomsII.minimumRooms(new int[][] {{4, 4}}));
        assertThrows(IllegalArgumentException.class,
                () -> MeetingRoomsII.minimumRooms(new int[][] {{4}}));
        assertThrows(NullPointerException.class,
                () -> MeetingRoomsII.minimumRooms(new int[][] {null}));
    }
}
