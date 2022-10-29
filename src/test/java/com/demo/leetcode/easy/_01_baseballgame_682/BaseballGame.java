package com.demo.leetcode.easy._01_baseballgame_682;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [682. Baseball Game - EASY](https://leetcode.com/problems/baseball-game/)
 *
 * - stack
 *
 * https://www.youtube.com/watch?v=Id_tqGdsZQI&ab_channel=NeetCode
 */
public class BaseballGame {

    @Test
    public void test1() {
        String[] ops = {"5", "2", "C", "D", "+"};
        Assertions.assertEquals(30, calPoints(ops));
    }

    @Test
    public void test2() {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        Assertions.assertEquals(27, calPoints(ops));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int temp_sum = temp1 + temp2;
                sum += temp_sum;
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp_sum);
            } else if (ops[i].equals("D")) {
                int temp = stack.pop();
                int temp_d = 2 * temp;
                sum += temp_d;
                stack.push(temp);
                stack.push(temp_d);
            } else if (ops[i].equals("C")) {
                int cancel = stack.pop();
                sum -= cancel;
            } else {
                int temp = Integer.parseInt(ops[i]);
                sum += temp;
                stack.push(temp);
            }
        }
        return sum;
    }
}
