package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReorderListTest {
    @Test
    void reordersEvenLengthList() {
        ReorderList.ListNode head = list(1, 2, 3, 4);

        ReorderList.reorder(head);

        assertArrayEquals(new int[] {1, 4, 2, 3}, toArray(head));
    }

    @Test
    void reordersOddLengthList() {
        ReorderList.ListNode head = list(1, 2, 3, 4, 5);

        ReorderList.reorder(head);

        assertArrayEquals(new int[] {1, 5, 2, 4, 3}, toArray(head));
    }

    @Test
    void keepsTwoNodeListUnchanged() {
        ReorderList.ListNode head = list(1, 2);

        ReorderList.reorder(head);

        assertArrayEquals(new int[] {1, 2}, toArray(head));
    }

    @Test
    void keepsSingleNodeListUnchanged() {
        ReorderList.ListNode head = list(7);

        ReorderList.reorder(head);

        assertArrayEquals(new int[] {7}, toArray(head));
    }

    @Test
    void handlesEmptyList() {
        ReorderList.ListNode head = null;

        ReorderList.reorder(head);

        assertNull(head);
    }

    private static ReorderList.ListNode list(int... values) {
        ReorderList.ListNode dummy = new ReorderList.ListNode(0);
        ReorderList.ListNode current = dummy;

        for (int value : values) {
            current.next = new ReorderList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(ReorderList.ListNode head) {
        int length = 0;
        for (ReorderList.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (ReorderList.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
