package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RemoveLinkedListElementsTest {
    @Test
    void removesMatchingValuesFromMiddleAndTail() {
        RemoveLinkedListElements.ListNode result = RemoveLinkedListElements.removeElements(
                list(1, 2, 6, 3, 4, 5, 6),
                6);

        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, toArray(result));
    }

    @Test
    void removesMatchingValuesFromHead() {
        RemoveLinkedListElements.ListNode result = RemoveLinkedListElements.removeElements(
                list(7, 7, 1, 2, 7),
                7);

        assertArrayEquals(new int[] {1, 2}, toArray(result));
    }

    @Test
    void returnsNullWhenEveryNodeIsRemoved() {
        RemoveLinkedListElements.ListNode result = RemoveLinkedListElements.removeElements(
                list(4, 4, 4),
                4);

        assertNull(result);
    }

    @Test
    void keepsListWhenValueIsAbsent() {
        RemoveLinkedListElements.ListNode result = RemoveLinkedListElements.removeElements(
                list(1, 2, 3),
                9);

        assertArrayEquals(new int[] {1, 2, 3}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(RemoveLinkedListElements.removeElements(null, 1));
    }

    private static RemoveLinkedListElements.ListNode list(int... values) {
        RemoveLinkedListElements.ListNode dummy = new RemoveLinkedListElements.ListNode(0);
        RemoveLinkedListElements.ListNode current = dummy;

        for (int value : values) {
            current.next = new RemoveLinkedListElements.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(RemoveLinkedListElements.ListNode head) {
        int length = 0;
        for (RemoveLinkedListElements.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (RemoveLinkedListElements.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
