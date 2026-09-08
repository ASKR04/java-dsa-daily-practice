package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class MiddleOfLinkedListTest {
    @Test
    void returnsMiddleNodeForOddLengthList() {
        MiddleOfLinkedList.ListNode head = list(1, 2, 3, 4, 5);

        MiddleOfLinkedList.ListNode middle = MiddleOfLinkedList.middleNode(head);

        assertSame(nodeAt(head, 2), middle);
    }

    @Test
    void returnsSecondMiddleNodeForEvenLengthList() {
        MiddleOfLinkedList.ListNode head = list(1, 2, 3, 4, 5, 6);

        MiddleOfLinkedList.ListNode middle = MiddleOfLinkedList.middleNode(head);

        assertSame(nodeAt(head, 3), middle);
    }

    @Test
    void returnsOnlyNodeForSingleElementList() {
        MiddleOfLinkedList.ListNode head = new MiddleOfLinkedList.ListNode(7);

        assertSame(head, MiddleOfLinkedList.middleNode(head));
    }

    @Test
    void handlesEmptyList() {
        assertNull(MiddleOfLinkedList.middleNode(null));
    }

    private static MiddleOfLinkedList.ListNode list(int... values) {
        MiddleOfLinkedList.ListNode dummy = new MiddleOfLinkedList.ListNode(0);
        MiddleOfLinkedList.ListNode current = dummy;

        for (int value : values) {
            current.next = new MiddleOfLinkedList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static MiddleOfLinkedList.ListNode nodeAt(MiddleOfLinkedList.ListNode head, int index) {
        MiddleOfLinkedList.ListNode current = head;

        for (int position = 0; position < index; position++) {
            current = current.next;
        }

        return current;
    }
}
