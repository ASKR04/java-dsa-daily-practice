package dev.daily.dsa;

public final class SwapNodesInPairs {
    private SwapNodesInPairs() {
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;
        while (previous.next != null && previous.next.next != null) {
            ListNode first = previous.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            previous.next = second;

            previous = first;
        }

        return dummy.next;
    }

    public static final class ListNode {
        public final int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
