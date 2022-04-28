package com.demo.leetcode.medium._15_maxsubarrayminproduct_1856;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1856. Maximum Subarray Min-Product - MEDIUM](https://leetcode.com/problems/maximum-subarray-min-product/)
 *
 * - monotonic increasing stack
 * - prefix sum
 * - SIMILAR_TO: [84. Largest Rectangle in Histogram - HARD](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 * - SIMILAR_TO: [85. Maximal Rectangle - HARD](https://leetcode.com/problems/maximal-rectangle/)
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=YLesLbNkyjA&ab_channel=NeetCode
 */
public class MaxSubarrayMinProduct {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2};
        Assertions.assertEquals(14, maxSumMinProduct(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int maxSumMinProduct(int[] nums) {
        long result = 0;
        //stack holds index
        Stack<Integer> stack = new Stack<>();
        long[] prefix = new long[nums.length + 1];

        //prefix sum
        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int minVal = nums[stack.pop()];
                long sum = stack.isEmpty() ? prefix[i] : prefix[i] - prefix[stack.peek() + 1];
                result = Math.max(result, minVal * sum);
            }
            stack.push(i);
        }
        //process remaining elements on stack
        while (!stack.isEmpty()) {
            int minVal = nums[stack.pop()];
            long sum = stack.isEmpty() ? prefix[nums.length] : prefix[nums.length] - prefix[stack.peek() + 1];
            result = Math.max(result, minVal * sum);
        }
        return (int) (result % 1000000007);
    }
}
