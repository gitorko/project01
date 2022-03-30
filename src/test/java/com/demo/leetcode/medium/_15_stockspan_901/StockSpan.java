package com.demo.leetcode.medium._15_stockspan_901;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [901. Online Stock Span - MEDIUM](https://leetcode.com/problems/online-stock-span/)
 *
 * - stack
 * - index of nearest greater to left - i
 *
 * https://www.youtube.com/watch?v=slYh0ZNEqSw&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&ab_channel=AdityaVerma
 */
public class StockSpan {

    @Test
    public void test() {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        int[] expected = {1, 1, 1, 2, 1, 4, 6};
        int[] result = stockSpanner(nums);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(expected, result);
    }

    public int[] stockSpanner(int[] nums) {
        // (nearest great element, index)
        Stack<Integer[]> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            System.out.println();
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = i - (-1);
            }
            if (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                result[i] = i - stack.peek()[1];
            }
            stack.push(new Integer[]{nums[i], i});
        }
        return result;
    }
}
