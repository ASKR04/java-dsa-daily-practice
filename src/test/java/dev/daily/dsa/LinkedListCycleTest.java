package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListCycleTest {
    @Test
    void returnsFalseForEmptyList() {
        assertFalse(LinkedListCycle.hasCycle(null));
    }

    @Test
    void returnsFalseForAcyclicList() {
        LinkedListCycle.ListNode head = list(1, 2, 3, 4);

        assertFalse(LinkedListCycle.hasCycle(head));
    }

    @Test
    void detectsCycleBackToMiddleNode() {
        LinkedListCycle.ListNode head = list(3, 2, 0, -4);
        LinkedListCycle.ListNode tail = nodeAt(head, 3);
        tail.next = nodeAt(head, 1);

        assertTrue(LinkedListCycle.hasCycle(head));
    }

    @Test
    void detectsSelfCycle() {
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        head.next = head;

        assertTrue(LinkedListCycle.hasCycle(head));
    }

    private static LinkedListCycle.ListNode list(int... values) {
        LinkedListCycle.ListNode dummy = new LinkedListCycle.ListNode(0);
        LinkedListCycle.ListNode current = dummy;

        for (int value : values) {
            current.next = new LinkedListCycle.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static LinkedListCycle.ListNode nodeAt(LinkedListCycle.ListNode head, int index) {
        LinkedListCycle.ListNode current = head;

        for (int position = 0; position < index; position++) {
            current = current.next;
        }

        return current;
    }
}
