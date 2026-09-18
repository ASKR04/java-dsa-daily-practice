package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SortListTest {
    @Test
    void sortsUnorderedList() {
        SortList.ListNode result = SortList.sort(list(4, 2, 1, 3));

        assertArrayEquals(new int[] {1, 2, 3, 4}, toArray(result));
    }

    @Test
    void sortsNegativeAndPositiveValues() {
        SortList.ListNode result = SortList.sort(list(-1, 5, 3, 4, 0));

        assertArrayEquals(new int[] {-1, 0, 3, 4, 5}, toArray(result));
    }

    @Test
    void preservesDuplicateValues() {
        SortList.ListNode result = SortList.sort(list(3, 1, 2, 3, 1));

        assertArrayEquals(new int[] {1, 1, 2, 3, 3}, toArray(result));
    }

    @Test
    void keepsSortedListInOrder() {
        SortList.ListNode result = SortList.sort(list(1, 2, 3, 4));

        assertArrayEquals(new int[] {1, 2, 3, 4}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(SortList.sort(null));
    }

    private static SortList.ListNode list(int... values) {
        SortList.ListNode dummy = new SortList.ListNode(0);
        SortList.ListNode current = dummy;

        for (int value : values) {
            current.next = new SortList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(SortList.ListNode head) {
        int length = 0;
        for (SortList.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (SortList.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
