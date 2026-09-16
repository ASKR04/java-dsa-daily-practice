package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RotateListTest {
    @Test
    void rotatesListRightByKPlaces() {
        RotateList.ListNode result = RotateList.rotateRight(list(1, 2, 3, 4, 5), 2);

        assertArrayEquals(new int[] {4, 5, 1, 2, 3}, toArray(result));
    }

    @Test
    void reducesRotationLargerThanLength() {
        RotateList.ListNode result = RotateList.rotateRight(list(0, 1, 2), 4);

        assertArrayEquals(new int[] {2, 0, 1}, toArray(result));
    }

    @Test
    void keepsListWhenRotationIsMultipleOfLength() {
        RotateList.ListNode result = RotateList.rotateRight(list(1, 2, 3), 6);

        assertArrayEquals(new int[] {1, 2, 3}, toArray(result));
    }

    @Test
    void handlesSingleNode() {
        RotateList.ListNode result = RotateList.rotateRight(list(7), 99);

        assertArrayEquals(new int[] {7}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(RotateList.rotateRight(null, 3));
    }

    private static RotateList.ListNode list(int... values) {
        RotateList.ListNode dummy = new RotateList.ListNode(0);
        RotateList.ListNode current = dummy;

        for (int value : values) {
            current.next = new RotateList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(RotateList.ListNode head) {
        int length = 0;
        for (RotateList.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (RotateList.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
