package com.demo.leetcode.medium._07_parenthesisgenerate_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [22. Generate Parentheses - MEDIUM](https://leetcode.com/problems/generate-parentheses/)
 *
 * - backtracking
 * - open+close counter,
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=s9fokUqJ76A&ab_channel=NeetCode
 */
public class GenerateParenthesis {

    @Test
    public void test() {
        List<String> expected = Arrays.asList("(())", "()()");
        Assertions.assertEquals(expected, generateParenthesis(2));
    }

    /**
     * Time: O(2^2n)
     * Space: O(n)
     *
     * - if n = 3 then string can be of length 3 * 2 = 6. 3 opening, 3 closing
     * - can add ( only if open < n
     * - can add ) only if close < open
     */
    List<String> result;
    int n;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        this.n = n;
        backtrack("", 0, 0);
        return result;
    }

    public void backtrack(String str, int open, int close) {
        //end when string is double the value of n.
        if (str.length() == n * 2) {
            result.add(str);
            return;
        }
        if (open < n) {
            backtrack(str + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(str + ")", open, close + 1);
        }
    }
}
