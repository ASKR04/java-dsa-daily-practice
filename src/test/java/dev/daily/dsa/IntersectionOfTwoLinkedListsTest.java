package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class IntersectionOfTwoLinkedListsTest {
    @Test
    void findsIntersectionAfterDifferentLengthPrefixes() {
        IntersectionOfTwoLinkedLists.ListNode shared = list(8, 4, 5);
        IntersectionOfTwoLinkedLists.ListNode headA = list(4, 1);
        IntersectionOfTwoLinkedLists.ListNode headB = list(5, 6, 1);
        tail(headA).next = shared;
        tail(headB).next = shared;

        assertSame(shared, IntersectionOfTwoLinkedLists.getIntersectionNode(headA, headB));
    }

    @Test
    void returnsHeadWhenListsStartAtSameNode() {
        IntersectionOfTwoLinkedLists.ListNode sharedHead = list(1, 2, 3);

        assertSame(sharedHead, IntersectionOfTwoLinkedLists.getIntersectionNode(sharedHead, sharedHead));
    }

    @Test
    void returnsNullWhenListsDoNotIntersect() {
        IntersectionOfTwoLinkedLists.ListNode headA = list(2, 6, 4);
        IntersectionOfTwoLinkedLists.ListNode headB = list(1, 5);

        assertNull(IntersectionOfTwoLinkedLists.getIntersectionNode(headA, headB));
    }

    @Test
    void handlesOneEmptyList() {
        assertNull(IntersectionOfTwoLinkedLists.getIntersectionNode(list(1, 2), null));
    }

    @Test
    void handlesBothListsEmpty() {
        assertNull(IntersectionOfTwoLinkedLists.getIntersectionNode(null, null));
    }

    private static IntersectionOfTwoLinkedLists.ListNode list(int... values) {
        IntersectionOfTwoLinkedLists.ListNode dummy = new IntersectionOfTwoLinkedLists.ListNode(0);
        IntersectionOfTwoLinkedLists.ListNode current = dummy;

        for (int value : values) {
            current.next = new IntersectionOfTwoLinkedLists.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static IntersectionOfTwoLinkedLists.ListNode tail(IntersectionOfTwoLinkedLists.ListNode head) {
        IntersectionOfTwoLinkedLists.ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }
}
