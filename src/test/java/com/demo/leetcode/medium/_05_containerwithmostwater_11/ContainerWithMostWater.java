package com.demo.leetcode.medium._05_containerwithmostwater_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [11. Container With Most Water - MEDIUM](https://leetcode.com/problems/container-with-most-water/)
 *
 * - two pointer, sliding window
 * - start from both ends
 *
 * https://www.youtube.com/watch?v=UuiTKBwPgAo&ab_channel=NeetCode
 */
public class ContainerWithMostWater {

    @Test
    public void test1() {
        int nums[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assertions.assertEquals(49, maxArea(nums));
    }

    @Test
    public void test2() {
        int nums[] = {1, 1};
        Assertions.assertEquals(1, maxArea(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
