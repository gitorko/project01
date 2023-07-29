package com.demo.leetcode.hard._15_largestrectanglehistogram_84;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [84. Largest Rectangle in Histogram - HARD](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 *
 * - monotonic stack
 * - SIMILAR_TO: [85. Maximal Rectangle - HARD](https://leetcode.com/problems/maximal-rectangle/)
 * - SIMILAR_TO: [1856. Maximum Subarray Min-Product - MEDIUM](https://leetcode.com/problems/maximum-subarray-min-product/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=zx5Sw9130L0&ab_channel=NeetCode
 */
public class LargestRectangleHistogram {

    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Assertions.assertEquals(10, largestRectangleArea(heights));
    }

    @Test
    public void test2() {
        int[] heights = {1, 2, 3, 4};
        Assertions.assertEquals(6, largestRectangleArea(heights));
    }

    @Test
    public void test3() {
        int[] heights = {4, 2, 0, 3, 2, 5};
        Assertions.assertEquals(6, largestRectangleArea(heights));
    }

    @Test
    public void test4() {
        int[] heights = {2,1,2};
        Assertions.assertEquals(3, largestRectangleArea(heights));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        //[index]
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int h = heights[index];
                //Don't forget edge case of stack empty
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        //process remaining elements on stack
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = heights[index];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

}
