package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {
    @Test
    void addsListsWithSameLengthAndCarry() {
        AddTwoNumbers.ListNode result = AddTwoNumbers.addTwoNumbers(
                list(2, 4, 3),
                list(5, 6, 4));

        assertArrayEquals(new int[] {7, 0, 8}, toArray(result));
    }

    @Test
    void addsListsWithDifferentLengths() {
        AddTwoNumbers.ListNode result = AddTwoNumbers.addTwoNumbers(
                list(9, 9, 9, 9, 9, 9, 9),
                list(9, 9, 9, 9));

        assertArrayEquals(new int[] {8, 9, 9, 9, 0, 0, 0, 1}, toArray(result));
    }

    @Test
    void handlesZeroInputs() {
        AddTwoNumbers.ListNode result = AddTwoNumbers.addTwoNumbers(
                list(0),
                list(0));

        assertArrayEquals(new int[] {0}, toArray(result));
    }

    @Test
    void appendsFinalCarry() {
        AddTwoNumbers.ListNode result = AddTwoNumbers.addTwoNumbers(
                list(5),
                list(5));

        assertArrayEquals(new int[] {0, 1}, toArray(result));
    }

    private static AddTwoNumbers.ListNode list(int... values) {
        AddTwoNumbers.ListNode dummy = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode current = dummy;

        for (int value : values) {
            current.next = new AddTwoNumbers.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    private static int[] toArray(AddTwoNumbers.ListNode head) {
        int length = 0;
        for (AddTwoNumbers.ListNode current = head; current != null; current = current.next) {
            length++;
        }

        int[] values = new int[length];
        int index = 0;
        for (AddTwoNumbers.ListNode current = head; current != null; current = current.next) {
            values[index++] = current.value;
        }

        return values;
    }
}
