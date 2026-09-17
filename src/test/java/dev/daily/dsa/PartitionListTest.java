package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PartitionListTest {
    @Test
    void partitionsNodesAroundPivot() {
        PartitionList.ListNode result = PartitionList.partition(list(1, 4, 3, 2, 5, 2), 3);

        assertArrayEquals(new int[] {1, 2, 2, 4, 3, 5}, toArray(result));
    }

    @Test
    void preservesRelativeOrderInBothPartitions() {
        PartitionList.ListNode result = PartitionList.partition(list(3, 1, 2, 5, 2, 4), 3);

        assertArrayEquals(new int[] {1, 2, 2, 3, 5, 4}, toArray(result));
    }

    @Test
    void keepsListWhenAllNodesAreLessThanPivot() {
        PartitionList.ListNode result = PartitionList.partition(list(1, 2, 0), 3);

        assertArrayEquals(new int[] {1, 2, 0}, toArray(result));
    }

    @Test
    void keepsListWhenNoNodesAreLessThanPivot() {
        PartitionList.ListNode result = PartitionList.partition(list(3, 5, 4), 3);

        assertArrayEquals(new int[] {3, 5, 4}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(PartitionList.partition(null, 3));
    }

    private static PartitionList.ListNode list(int... values) {
        PartitionList.ListNode dummy = new PartitionList.ListNode(0);
        PartitionList.ListNode current = dummy;

        for (int value : values) {
            current.next = new PartitionList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(PartitionList.ListNode head) {
        int length = 0;
        for (PartitionList.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (PartitionList.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
