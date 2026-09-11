package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class MergeTwoSortedListsTest {
    @Test
    void mergesTwoSortedLists() {
        MergeTwoSortedLists.ListNode first = list(1, 2, 4);
        MergeTwoSortedLists.ListNode second = list(1, 3, 4);

        MergeTwoSortedLists.ListNode merged = MergeTwoSortedLists.mergeTwoLists(first, second);

        assertArrayEquals(new int[] {1, 1, 2, 3, 4, 4}, values(merged));
    }

    @Test
    void returnsOtherListWhenOneListIsEmpty() {
        MergeTwoSortedLists.ListNode second = list(0, 5);

        MergeTwoSortedLists.ListNode merged = MergeTwoSortedLists.mergeTwoLists(null, second);

        assertSame(second, merged);
        assertArrayEquals(new int[] {0, 5}, values(merged));
    }

    @Test
    void returnsNullWhenBothListsAreEmpty() {
        assertNull(MergeTwoSortedLists.mergeTwoLists(null, null));
    }

    @Test
    void preservesRemainingTailWhenFirstListEnds() {
        MergeTwoSortedLists.ListNode first = list(1);
        MergeTwoSortedLists.ListNode second = list(2, 3, 4);

        MergeTwoSortedLists.ListNode merged = MergeTwoSortedLists.mergeTwoLists(first, second);

        assertArrayEquals(new int[] {1, 2, 3, 4}, values(merged));
    }

    private static MergeTwoSortedLists.ListNode list(int... values) {
        MergeTwoSortedLists.ListNode dummy = new MergeTwoSortedLists.ListNode(0);
        MergeTwoSortedLists.ListNode current = dummy;

        for (int value : values) {
            current.next = new MergeTwoSortedLists.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] values(MergeTwoSortedLists.ListNode head) {
        int size = 0;
        MergeTwoSortedLists.ListNode current = head;
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
