package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ReverseLinkedListTest {
    @Test
    void reversesMultipleNodes() {
        ReverseLinkedList.ListNode head = list(1, 2, 3, 4, 5);

        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverse(head);

        assertArrayEquals(new int[] {5, 4, 3, 2, 1}, values(reversed));
    }

    @Test
    void reversesTwoNodes() {
        ReverseLinkedList.ListNode head = list(10, 20);

        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverse(head);

        assertArrayEquals(new int[] {20, 10}, values(reversed));
    }

    @Test
    void returnsSameNodeForSingleElementList() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(7);

        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverse(head);

        assertSame(head, reversed);
        assertNull(reversed.next);
    }

    @Test
    void handlesEmptyList() {
        assertNull(ReverseLinkedList.reverse(null));
    }

    private static ReverseLinkedList.ListNode list(int... values) {
        ReverseLinkedList.ListNode dummy = new ReverseLinkedList.ListNode(0);
        ReverseLinkedList.ListNode current = dummy;

        for (int value : values) {
            current.next = new ReverseLinkedList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] values(ReverseLinkedList.ListNode head) {
        int size = 0;
        ReverseLinkedList.ListNode current = head;
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
