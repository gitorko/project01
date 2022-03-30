package com.demo.leetcode.hard._15_largestrectanglehistogram_84;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [84. Largest Rectangle in Histogram - HARD](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 *
 * - monotonic stack
 * - process left over elements in stack
 * - SIMILAR_TO: [85. Maximal Rectangle - HARD](https://leetcode.com/problems/maximal-rectangle/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=zx5Sw9130L0&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=vcv3REtIvEo&ab_channel=TECHDOSE
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

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        //i <= because we want to pop last element from stack
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

}
