package com.demo.leetcode.medium._15_stockspan_901;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [901. Online Stock Span - MEDIUM](https://leetcode.com/problems/online-stock-span/)
 *
 * - monotonic stack (decreasing)
 * - index of nearest greater to left - i
 * - SIMILAR_TO: [Nearest Greater to Right - EASY]()
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=slYh0ZNEqSw&ab_channel=NeetCode
 */
public class StockSpan {

    @Test
    public void test1() {
        StockSpanner stockSpanner = new StockSpanner();
        Assertions.assertEquals(1, stockSpanner.next(100));
        Assertions.assertEquals(1, stockSpanner.next(80));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(2, stockSpanner.next(70));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(4, stockSpanner.next(75));
        Assertions.assertEquals(6, stockSpanner.next(85));
    }

    class StockSpanner {
        //[price, span]
        Stack<int[]> stack = new Stack<>();
        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }
}
