package com.demo.leetcode.medium._14_courseschedule2_210;

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
 * [210. Course Schedule II - MEDIUM](https://leetcode.com/problems/course-schedule-ii/)
 *
 * - topological sort
 * - SIMILAR_TO: [207. Course Schedule - MEDIUM](https://leetcode.com/problems/course-schedule/)
 *
 * https://www.youtube.com/watch?v=Akt3glAwyfY&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=ddTC4Zovtbc&ab_channel=TusharRoy-CodingMadeSimple
 */
public class CourseSchedule2 {

    @Test
    public void test1() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, findOrder(numCourses, prerequisites));
    }

    @Test
    public void test2() {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, findOrder(numCourses, prerequisites));
    }

    /**
     * Time: O(E + V)
     */
    Set<Integer> cycleSet;
    Set<Integer> visitedSet;
    Map<Integer, List<Integer>> preMap;
    List<Integer> result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        cycleSet = new HashSet<>();
        visitedSet = new HashSet<>();
        result = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Integer course1 = prerequisites[i][0];
            Integer course2 = prerequisites[i][1];
            List<Integer> courses = preMap.getOrDefault(course1, new ArrayList<>());
            courses.add(course2);
            preMap.put(course1, courses);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[]{};
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public boolean dfs(Integer course) {
        List<Integer> preReqs = preMap.getOrDefault(course, Collections.emptyList());
        if (cycleSet.contains(course)) {
            return false;
        }
        if (visitedSet.contains(course)) {
            return true;
        }
        cycleSet.add(course);
        for (Integer preReq : preReqs) {
            if (!dfs(preReq)) return false;
        }
        cycleSet.remove(course);
        visitedSet.add(course);
        //use list as set doesnt guarantee order, or use LinkedHashSet
        result.add(course);
        return true;
    }

}
