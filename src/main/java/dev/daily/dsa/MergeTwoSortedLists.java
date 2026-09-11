package dev.daily.dsa;

public final class MergeTwoSortedLists {
    private MergeTwoSortedLists() {
    }

    public static ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (first != null && second != null) {
            if (first.value <= second.value) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        tail.next = first != null ? first : second;
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
