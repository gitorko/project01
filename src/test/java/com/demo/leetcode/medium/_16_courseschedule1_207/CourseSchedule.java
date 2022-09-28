package com.demo.leetcode.medium._16_courseschedule1_207;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [207. Course Schedule - MEDIUM](https://leetcode.com/problems/course-schedule/)
 *
 * - dfs, adjacency list
 * - SIMILAR_TO: [210. Course Schedule II - MEDIUM](https://leetcode.com/problems/course-schedule-ii/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=EgI5nU9etnU&ab_channel=NeetCode
 */
public class CourseSchedule {

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        Assertions.assertTrue(canFinish(numCourses, prerequisites));
    }

    @Test
    public void test2() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Assertions.assertFalse(canFinish(numCourses, prerequisites));
    }

    @Test
    public void test3() {
        int numCourses = 4;
        int[][] prerequisites = {{0, 1}, {1, 2}, {3, 2}};
        Assertions.assertTrue(canFinish(numCourses, prerequisites));
    }

    @Test
    public void test4() {
        int numCourses = 4;
        int[][] prerequisites = {{0, 1}, {1, 2}, {3, 1}};
        Assertions.assertTrue(canFinish(numCourses, prerequisites));
    }

    /**
     * Time: O(n+p)
     */
    Set<Integer> visitedSet;
    Map<Integer, List<Integer>> adjacencyMap;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacencyMap = new HashMap<>();
        visitedSet = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Integer course1 = prerequisites[i][0];
            Integer course2 = prerequisites[i][1];
            List<Integer> courses = adjacencyMap.getOrDefault(course1, new ArrayList<>());
            courses.add(course2);
            adjacencyMap.put(course1, courses);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(Integer course) {
        List<Integer> preReqs = adjacencyMap.getOrDefault(course, Collections.emptyList());

        //already visited.
        if (visitedSet.contains(course)) {
            return false;
        }
        //no other pre requisite
        if (preReqs.isEmpty()) {
            return true;
        }
        visitedSet.add(course);
        for (Integer preReq : preReqs) {
            if (!dfs(preReq)) return false;
        }
        visitedSet.remove(course);
        //remember to set the preReq to empty, will run into timeout exception on large data set if not cleared.
        adjacencyMap.put(course, Collections.emptyList());
        return true;
    }

}
