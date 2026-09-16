package dev.daily.dsa;

public final class RotateList {
    private RotateList() {
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int rotation = k % length;
        if (rotation == 0) {
            return head;
        }

        tail.next = head;
        int stepsToNewTail = length - rotation - 1;
        ListNode newTail = head;
        for (int step = 0; step < stepsToNewTail; step++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static final class ListNode {
        public final int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
