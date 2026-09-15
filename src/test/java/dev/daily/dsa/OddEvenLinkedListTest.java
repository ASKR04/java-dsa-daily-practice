package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class OddEvenLinkedListTest {
    @Test
    void groupsOddIndexedNodesBeforeEvenIndexedNodes() {
        OddEvenLinkedList.ListNode result = OddEvenLinkedList.oddEvenList(list(1, 2, 3, 4, 5));

        assertArrayEquals(new int[] {1, 3, 5, 2, 4}, toArray(result));
    }

    @Test
    void preservesRelativeOrderInsideEachGroup() {
        OddEvenLinkedList.ListNode result = OddEvenLinkedList.oddEvenList(list(2, 1, 3, 5, 6, 4, 7));

        assertArrayEquals(new int[] {2, 3, 6, 7, 1, 5, 4}, toArray(result));
    }

    @Test
    void handlesTwoNodes() {
        OddEvenLinkedList.ListNode result = OddEvenLinkedList.oddEvenList(list(10, 20));

        assertArrayEquals(new int[] {10, 20}, toArray(result));
    }

    @Test
    void handlesSingleNode() {
        OddEvenLinkedList.ListNode result = OddEvenLinkedList.oddEvenList(list(42));

        assertArrayEquals(new int[] {42}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(OddEvenLinkedList.oddEvenList(null));
    }

    private static OddEvenLinkedList.ListNode list(int... values) {
        OddEvenLinkedList.ListNode dummy = new OddEvenLinkedList.ListNode(0);
        OddEvenLinkedList.ListNode current = dummy;

        for (int value : values) {
            current.next = new OddEvenLinkedList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(OddEvenLinkedList.ListNode head) {
        int length = 0;
        for (OddEvenLinkedList.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (OddEvenLinkedList.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
