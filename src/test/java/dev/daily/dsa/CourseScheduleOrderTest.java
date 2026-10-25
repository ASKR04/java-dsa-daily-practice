package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CourseScheduleOrderTest {
    @Test
    void returnsValidOrderForBranchingPlan() {
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] order = CourseScheduleOrder.findOrder(4, prerequisites);

        assertEquals(4, order.length);
        assertPrerequisitesComeFirst(order, prerequisites);
    }

    @Test
    void returnsEmptyOrderForCycle() {
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {0, 2}
        };

        assertArrayEquals(new int[0], CourseScheduleOrder.findOrder(3, prerequisites));
    }

    @Test
    void returnsEveryCourseWhenThereAreNoPrerequisites() {
        assertArrayEquals(
                new int[] {0, 1, 2},
                CourseScheduleOrder.findOrder(3, new int[0][]));
    }

    @Test
    void handlesEmptyCourseList() {
        assertArrayEquals(new int[0], CourseScheduleOrder.findOrder(0, new int[0][]));
    }

    @Test
    void doesNotModifyPrerequisites() {
        int[][] prerequisites = {{1, 0}, {2, 1}};
        int[][] original = {prerequisites[0].clone(), prerequisites[1].clone()};

        CourseScheduleOrder.findOrder(3, prerequisites);

        assertArrayEquals(original[0], prerequisites[0]);
        assertArrayEquals(original[1], prerequisites[1]);
    }

    @Test
    void rejectsMalformedPrerequisite() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseScheduleOrder.findOrder(2, new int[][] {{1}}));
    }

    @Test
    void rejectsOutOfRangeCourse() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseScheduleOrder.findOrder(2, new int[][] {{1, 2}}));
    }

    private static void assertPrerequisitesComeFirst(
            int[] order,
            int[][] prerequisites) {
        int[] positions = new int[order.length];
        for (int index = 0; index < order.length; index++) {
            positions[order[index]] = index;
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];
            org.junit.jupiter.api.Assertions.assertTrue(
                    positions[requiredCourse] < positions[course]);
        }
    }
}
