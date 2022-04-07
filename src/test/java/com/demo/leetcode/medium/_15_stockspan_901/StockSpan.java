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
 */
public class StockSpan {

    @Test
    public void test1() {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        int[] expected = {1, 1, 1, 2, 1, 4, 6};
        int[] result = stockSpanner(nums);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        StockSpanner stockSpanner = new StockSpanner();
        Assertions.assertEquals(1, stockSpanner.next(100));
        Assertions.assertEquals(1, stockSpanner.next(80));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(2, stockSpanner.next(70));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(4, stockSpanner.next(75));
        Assertions.assertEquals(6, stockSpanner.next(85));
    }

    public int[] stockSpanner(int[] nums) {
        // (nearest great element, index)
        Stack<Integer[]> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
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

    class StockSpanner {
        //[price, span]
        Stack<int[]> stack = new Stack<>();

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price)
                span += stack.pop()[1];
            stack.push(new int[]{price, span});
            return span;
        }
    }
}
