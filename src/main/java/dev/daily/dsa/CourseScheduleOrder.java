package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public final class CourseScheduleOrder {
    private CourseScheduleOrder() {
    }

    public static int[] findOrder(int courseCount, int[][] prerequisites) {
        if (courseCount < 0) {
            throw new IllegalArgumentException("courseCount must not be negative");
        }
        Objects.requireNonNull(prerequisites, "prerequisites must not be null");

        List<List<Integer>> dependents = new ArrayList<>(courseCount);
        for (int course = 0; course < courseCount; course++) {
            dependents.add(new ArrayList<>());
        }

        int[] prerequisiteCounts = new int[courseCount];
        for (int[] prerequisite : prerequisites) {
            validatePrerequisite(prerequisite, courseCount);
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];
            dependents.get(requiredCourse).add(course);
            prerequisiteCounts[course]++;
        }

        Deque<Integer> readyCourses = new ArrayDeque<>();
        for (int course = 0; course < courseCount; course++) {
            if (prerequisiteCounts[course] == 0) {
                readyCourses.add(course);
            }
        }

        int[] order = new int[courseCount];
        int orderSize = 0;
        while (!readyCourses.isEmpty()) {
            int completedCourse = readyCourses.remove();
            order[orderSize++] = completedCourse;

            for (int dependent : dependents.get(completedCourse)) {
                prerequisiteCounts[dependent]--;
                if (prerequisiteCounts[dependent] == 0) {
                    readyCourses.add(dependent);
                }
            }
        }

        return orderSize == courseCount ? order : new int[0];
    }

    private static void validatePrerequisite(int[] prerequisite, int courseCount) {
        if (prerequisite == null || prerequisite.length != 2) {
            throw new IllegalArgumentException(
                    "each prerequisite must contain a course and its requirement");
        }

        for (int course : prerequisite) {
            if (course < 0 || course >= courseCount) {
                throw new IllegalArgumentException("course index is out of range");
            }
        }
    }
}
