package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public final class MinStack {
    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> minimums = new ArrayDeque<>();

    public void push(int value) {
        values.push(value);

        int currentMinimum = minimums.isEmpty() ? value : Math.min(value, minimums.peek());
        minimums.push(currentMinimum);
    }

    public int pop() {
        requireNotEmpty();
        minimums.pop();
        return values.pop();
    }

    public int top() {
        requireNotEmpty();
        return values.peek();
    }

    public int getMin() {
        requireNotEmpty();
        return minimums.peek();
    }

    public boolean empty() {
        return values.isEmpty();
    }

    private void requireNotEmpty() {
        if (values.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
    }
}
