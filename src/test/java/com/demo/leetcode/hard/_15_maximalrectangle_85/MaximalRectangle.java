package com.demo.leetcode.hard._15_maximalrectangle_85;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [85. Maximal Rectangle - HARD](https://leetcode.com/problems/maximal-rectangle/)
 *
 * - monotonic stack
 * - each row histogram
 * - SIMILAR_TO: [84. Largest Rectangle in Histogram - HARD](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 * - SIMILAR_TO: [1856. Maximum Subarray Min-Product - MEDIUM](https://leetcode.com/problems/maximum-subarray-min-product/)
 *
 * https://www.youtube.com/watch?v=dAVF2NpC3j4&ab_channel=TECHDOSE
 */
public class MaximalRectangle {

    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Assertions.assertEquals(6, maximalRectangle(matrix));
    }

    /**
     * Time: O(mn)
     * Space: O(n)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] hist = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                hist[j] = row[j] == '0' ? 0 : hist[j] + 1;
            }
            result = Math.max(result, largestRectangleArea(hist));
        }
        return result;
    }

    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        //[index]
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        //process remaining elements on stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
