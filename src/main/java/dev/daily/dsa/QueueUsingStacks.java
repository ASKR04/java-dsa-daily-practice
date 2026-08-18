package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public final class QueueUsingStacks {
    private final Deque<Integer> inStack = new ArrayDeque<>();
    private final Deque<Integer> outStack = new ArrayDeque<>();

    public void push(int value) {
        inStack.push(value);
    }

    public int pop() {
        moveToOutStackWhenNeeded();
        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return outStack.pop();
    }

    public int peek() {
        moveToOutStackWhenNeeded();
        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveToOutStackWhenNeeded() {
        if (!outStack.isEmpty()) {
            return;
        }

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
