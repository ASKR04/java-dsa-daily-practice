package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class LinkedListCycleIITest {
    @Test
    void findsCycleEntryInMiddle() {
        LinkedListCycleII.ListNode[] nodes = nodes(3, 2, 0, -4);
        link(nodes);
        nodes[3].next = nodes[1];

        assertSame(nodes[1], LinkedListCycleII.detectCycle(nodes[0]));
    }

    @Test
    void findsCycleEntryAtHead() {
        LinkedListCycleII.ListNode[] nodes = nodes(1, 2, 3);
        link(nodes);
        nodes[2].next = nodes[0];

        assertSame(nodes[0], LinkedListCycleII.detectCycle(nodes[0]));
    }

    @Test
    void handlesSelfCycle() {
        LinkedListCycleII.ListNode node = new LinkedListCycleII.ListNode(1);
        node.next = node;

        assertSame(node, LinkedListCycleII.detectCycle(node));
    }

    @Test
    void returnsNullForAcyclicList() {
        LinkedListCycleII.ListNode[] nodes = nodes(1, 2, 3);
        link(nodes);

        assertNull(LinkedListCycleII.detectCycle(nodes[0]));
    }

    @Test
    void returnsNullForEmptyList() {
        assertNull(LinkedListCycleII.detectCycle(null));
    }

    private static LinkedListCycleII.ListNode[] nodes(int... values) {
        LinkedListCycleII.ListNode[] nodes = new LinkedListCycleII.ListNode[values.length];
        for (int index = 0; index < values.length; index++) {
            nodes[index] = new LinkedListCycleII.ListNode(values[index]);
        }
        return nodes;
    }

    private static void link(LinkedListCycleII.ListNode[] nodes) {
        for (int index = 0; index + 1 < nodes.length; index++) {
            nodes[index].next = nodes[index + 1];
        }
    }
}
