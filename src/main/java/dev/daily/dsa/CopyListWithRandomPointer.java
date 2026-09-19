package dev.daily.dsa;

public final class CopyListWithRandomPointer {
    private CopyListWithRandomPointer() {
    }

    public static Node copy(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.value);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;
        while (current != null) {
            Node copy = current.next;
            copy.random = current.random == null ? null : current.random.next;
            current = copy.next;
        }

        Node copyHead = head.next;
        current = head;
        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;
            current = current.next;
        }

        return copyHead;
    }

    public static final class Node {
        public final int value;
        public Node next;
        public Node random;

        public Node(int value) {
            this.value = value;
        }
    }
}
