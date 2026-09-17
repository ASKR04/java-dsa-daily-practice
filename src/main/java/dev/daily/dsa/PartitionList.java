package dev.daily.dsa;

public final class PartitionList {
    private PartitionList() {
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);
        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        ListNode current = head;
        while (current != null) {
            if (current.value < x) {
                before.next = current;
                before = before.next;
            } else {
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }

        after.next = null;
        before.next = afterDummy.next;
        return beforeDummy.next;
    }

    public static final class ListNode {
        public final int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
