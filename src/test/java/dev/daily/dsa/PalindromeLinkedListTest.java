package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeLinkedListTest {
    @Test
    void returnsTrueForEvenLengthPalindrome() {
        PalindromeLinkedList.ListNode head = list(1, 2, 2, 1);

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    void returnsTrueForOddLengthPalindrome() {
        PalindromeLinkedList.ListNode head = list(1, 2, 3, 2, 1);

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        PalindromeLinkedList.ListNode head = list(1, 2, 3);

        assertFalse(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    void returnsTrueForSingleNode() {
        PalindromeLinkedList.ListNode head = list(7);

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    void returnsTrueForEmptyList() {
        assertTrue(PalindromeLinkedList.isPalindrome(null));
    }

    private static PalindromeLinkedList.ListNode list(int... values) {
        PalindromeLinkedList.ListNode dummy = new PalindromeLinkedList.ListNode(0);
        PalindromeLinkedList.ListNode current = dummy;

        for (int value : values) {
            current.next = new PalindromeLinkedList.ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }
}
