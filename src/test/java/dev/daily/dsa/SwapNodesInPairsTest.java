package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SwapNodesInPairsTest {
    @Test
    void swapsEveryAdjacentPairForEvenLengthList() {
        SwapNodesInPairs.ListNode result = SwapNodesInPairs.swapPairs(list(1, 2, 3, 4));

        assertArrayEquals(new int[] {2, 1, 4, 3}, toArray(result));
    }

    @Test
    void leavesLastNodeInPlaceForOddLengthList() {
        SwapNodesInPairs.ListNode result = SwapNodesInPairs.swapPairs(list(1, 2, 3, 4, 5));

        assertArrayEquals(new int[] {2, 1, 4, 3, 5}, toArray(result));
    }

    @Test
    void handlesTwoNodes() {
        SwapNodesInPairs.ListNode result = SwapNodesInPairs.swapPairs(list(7, 9));

        assertArrayEquals(new int[] {9, 7}, toArray(result));
    }

    @Test
    void handlesSingleNode() {
        SwapNodesInPairs.ListNode result = SwapNodesInPairs.swapPairs(list(1));

        assertArrayEquals(new int[] {1}, toArray(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(SwapNodesInPairs.swapPairs(null));
    }

    private static SwapNodesInPairs.ListNode list(int... values) {
        SwapNodesInPairs.ListNode dummy = new SwapNodesInPairs.ListNode(0);
        SwapNodesInPairs.ListNode current = dummy;

        for (int value : values) {
            current.next = new SwapNodesInPairs.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(SwapNodesInPairs.ListNode head) {
        int length = 0;
        for (SwapNodesInPairs.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (SwapNodesInPairs.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
