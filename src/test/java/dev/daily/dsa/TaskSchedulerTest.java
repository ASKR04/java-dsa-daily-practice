package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TaskSchedulerTest {
    @Test
    void insertsRequiredIdleIntervals() {
        assertEquals(
                8,
                TaskScheduler.leastIntervals(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    @Test
    void schedulesWithoutIdleTimeWhenCooldownIsZero() {
        assertEquals(
                6,
                TaskScheduler.leastIntervals(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }

    @Test
    void handlesLongerCooldown() {
        assertEquals(
                10,
                TaskScheduler.leastIntervals(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }

    @Test
    void usesOtherTasksToFillCooldownSlots() {
        assertEquals(
                7,
                TaskScheduler.leastIntervals(new char[] {'A', 'A', 'A', 'B', 'B', 'C'}, 2));
    }

    @Test
    void handlesEmptyTaskList() {
        assertEquals(0, TaskScheduler.leastIntervals(new char[0], 2));
    }

    @Test
    void doesNotModifyTaskArray() {
        char[] tasks = {'A', 'A', 'B'};
        char[] original = tasks.clone();

        TaskScheduler.leastIntervals(tasks, 1);

        assertArrayEquals(original, tasks);
    }

    @Test
    void rejectsNegativeCooldown() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TaskScheduler.leastIntervals(new char[] {'A'}, -1));
    }

    @Test
    void rejectsInvalidTaskName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TaskScheduler.leastIntervals(new char[] {'A', 'a'}, 1));
    }
}
