package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CourseScheduleTest {
    @Test
    void finishesAcyclicCoursePlan() {
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        assertTrue(CourseSchedule.canFinish(4, prerequisites));
    }

    @Test
    void detectsDirectedCycle() {
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {0, 2}
        };

        assertFalse(CourseSchedule.canFinish(3, prerequisites));
    }

    @Test
    void detectsSelfDependency() {
        assertFalse(CourseSchedule.canFinish(1, new int[][] {{0, 0}}));
    }

    @Test
    void handlesCoursesWithoutPrerequisites() {
        assertTrue(CourseSchedule.canFinish(5, new int[0][]));
        assertTrue(CourseSchedule.canFinish(0, new int[0][]));
    }

    @Test
    void doesNotModifyPrerequisites() {
        int[][] prerequisites = {{1, 0}, {2, 1}};
        int[][] original = {prerequisites[0].clone(), prerequisites[1].clone()};

        CourseSchedule.canFinish(3, prerequisites);

        assertArrayEquals(original[0], prerequisites[0]);
        assertArrayEquals(original[1], prerequisites[1]);
    }

    @Test
    void rejectsMalformedPrerequisite() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseSchedule.canFinish(2, new int[][] {{1}}));
    }

    @Test
    void rejectsOutOfRangeCourse() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseSchedule.canFinish(2, new int[][] {{2, 0}}));
    }

    @Test
    void rejectsNegativeCourseCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseSchedule.canFinish(-1, new int[0][]));
    }
}
