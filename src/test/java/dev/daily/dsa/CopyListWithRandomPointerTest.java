package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CopyListWithRandomPointerTest {
    @Test
    void copiesValuesAndRandomConnections() {
        CopyListWithRandomPointer.Node[] original = nodes(7, 13, 11, 10, 1);
        linkNext(original);
        original[1].random = original[0];
        original[2].random = original[4];
        original[3].random = original[2];
        original[4].random = original[0];

        CopyListWithRandomPointer.Node result = CopyListWithRandomPointer.copy(original[0]);

        assertArrayEquals(new int[] {7, 13, 11, 10, 1}, values(result));
        assertArrayEquals(new int[] {-1, 0, 4, 2, 0}, randomIndexes(result));
        assertDeepCopy(original, result);
    }

    @Test
    void restoresOriginalNextConnections() {
        CopyListWithRandomPointer.Node[] original = nodes(1, 2, 3);
        linkNext(original);
        original[0].random = original[2];

        CopyListWithRandomPointer.copy(original[0]);

        assertSame(original[1], original[0].next);
        assertSame(original[2], original[1].next);
        assertNull(original[2].next);
        assertSame(original[2], original[0].random);
    }

    @Test
    void copiesSelfReference() {
        CopyListWithRandomPointer.Node original = new CopyListWithRandomPointer.Node(5);
        original.random = original;

        CopyListWithRandomPointer.Node result = CopyListWithRandomPointer.copy(original);

        assertNotSame(original, result);
        assertSame(result, result.random);
        assertNull(result.next);
    }

    @Test
    void handlesEmptyList() {
        assertNull(CopyListWithRandomPointer.copy(null));
    }

    private static CopyListWithRandomPointer.Node[] nodes(int... values) {
        CopyListWithRandomPointer.Node[] nodes = new CopyListWithRandomPointer.Node[values.length];
        for (int index = 0; index < values.length; index++) {
            nodes[index] = new CopyListWithRandomPointer.Node(values[index]);
        }
        return nodes;
    }

    private static void linkNext(CopyListWithRandomPointer.Node[] nodes) {
        for (int index = 0; index + 1 < nodes.length; index++) {
            nodes[index].next = nodes[index + 1];
        }
    }

    private static int[] values(CopyListWithRandomPointer.Node head) {
        int[] values = new int[length(head)];
        int index = 0;
        for (CopyListWithRandomPointer.Node current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }
        return values;
    }

    private static int[] randomIndexes(CopyListWithRandomPointer.Node head) {
        CopyListWithRandomPointer.Node[] nodes = toArray(head);
        int[] indexes = new int[nodes.length];

        for (int index = 0; index < nodes.length; index++) {
            indexes[index] = indexOf(nodes, nodes[index].random);
        }
        return indexes;
    }

    private static void assertDeepCopy(
            CopyListWithRandomPointer.Node[] original,
            CopyListWithRandomPointer.Node copyHead) {
        CopyListWithRandomPointer.Node[] copies = toArray(copyHead);
        for (int index = 0; index < original.length; index++) {
            assertNotSame(original[index], copies[index]);
        }
    }

    private static CopyListWithRandomPointer.Node[] toArray(CopyListWithRandomPointer.Node head) {
        CopyListWithRandomPointer.Node[] nodes = new CopyListWithRandomPointer.Node[length(head)];
        int index = 0;
        for (CopyListWithRandomPointer.Node current = head; current != null; current = current.next) {
            nodes[index++] = current;
        }
        return nodes;
    }

    private static int indexOf(
            CopyListWithRandomPointer.Node[] nodes,
            CopyListWithRandomPointer.Node target) {
        if (target == null) {
            return -1;
        }

        for (int index = 0; index < nodes.length; index++) {
            if (nodes[index] == target) {
                return index;
            }
        }
        return -1;
    }

    private static int length(CopyListWithRandomPointer.Node head) {
        int length = 0;
        for (CopyListWithRandomPointer.Node current = head; current != null; current = current.next) {
            length++;
        }
        return length;
    }
}
