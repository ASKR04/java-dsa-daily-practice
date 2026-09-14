package dev.daily.dsa;

public final class RemoveLinkedListElements {
    private RemoveLinkedListElements() {
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.value == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
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
