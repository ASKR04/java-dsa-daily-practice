package dev.daily.dsa;

public final class AddTwoNumbers {
    private AddTwoNumbers() {
    }

    public static ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int firstDigit = first == null ? 0 : first.value;
            int secondDigit = second == null ? 0 : second.value;
            int sum = firstDigit + secondDigit + carry;

            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;

            first = first == null ? null : first.next;
            second = second == null ? null : second.next;
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
