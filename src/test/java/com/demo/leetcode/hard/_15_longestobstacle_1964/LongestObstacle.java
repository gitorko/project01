package com.demo.leetcode.hard._15_longestobstacle_1964;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1964. Find the Longest Valid Obstacle Course at Each Position - HARD](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/)
 *
 * https://www.youtube.com/watch?v=Xq9VT7p0lic&ab_channel=NeetCodeIO
 */
public class LongestObstacle {

    @Test
    public void test() {
        int[] obstacles = {1, 2, 3, 2};
        int[] result = {1, 2, 3, 3};
        Assertions.assertArrayEquals(result, longestObstacleCourseAtEachPosition(obstacles));
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        // smallest ending number of an increasing subsequence
        int[] dp = new int[n];
        // length of the longest increasing subsequence
        int[] result = new int[n];

        int len = 0;

        for (int i = 0; i < n; i++) {
            // find the position where we can add the current obstacle
            int idx = binarySearch(dp, 0, len - 1, obstacles[i]);

            // add the current obstacle to the dp array at the correct position
            dp[idx] = obstacles[i];

            if (idx == len) {
                // if we added the current obstacle to the end of the dp array
                // update the length of the longest increasing subsequence seen so far
                len++;
            }
            // update the length of the longest increasing subsequence that includes the i-th obstacle
            result[i] = idx + 1;
        }
        return result;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
