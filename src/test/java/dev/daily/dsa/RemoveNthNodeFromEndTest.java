package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RemoveNthNodeFromEndTest {
    @Test
    void removesNodeFromMiddle() {
        RemoveNthNodeFromEnd.ListNode head = list(1, 2, 3, 4, 5);

        RemoveNthNodeFromEnd.ListNode updated = RemoveNthNodeFromEnd.removeNthFromEnd(head, 2);

        assertArrayEquals(new int[] {1, 2, 3, 5}, values(updated));
    }

    @Test
    void removesHeadWhenNEqualsLength() {
        RemoveNthNodeFromEnd.ListNode head = list(1, 2, 3);

        RemoveNthNodeFromEnd.ListNode updated = RemoveNthNodeFromEnd.removeNthFromEnd(head, 3);

        assertArrayEquals(new int[] {2, 3}, values(updated));
    }

    @Test
    void removesTailWhenNIsOne() {
        RemoveNthNodeFromEnd.ListNode head = list(1, 2, 3);

        RemoveNthNodeFromEnd.ListNode updated = RemoveNthNodeFromEnd.removeNthFromEnd(head, 1);

        assertArrayEquals(new int[] {1, 2}, values(updated));
    }

    @Test
    void removesOnlyNode() {
        RemoveNthNodeFromEnd.ListNode head = list(1);

        assertNull(RemoveNthNodeFromEnd.removeNthFromEnd(head, 1));
    }

    private static RemoveNthNodeFromEnd.ListNode list(int... values) {
        RemoveNthNodeFromEnd.ListNode dummy = new RemoveNthNodeFromEnd.ListNode(0);
        RemoveNthNodeFromEnd.ListNode current = dummy;

        for (int value : values) {
            current.next = new RemoveNthNodeFromEnd.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] values(RemoveNthNodeFromEnd.ListNode head) {
        int size = 0;
        RemoveNthNodeFromEnd.ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        int[] values = new int[size];
        current = head;
        for (int index = 0; index < size; index++) {
            values[index] = current.value;
            current = current.next;
        }

        return values;
    }
}
