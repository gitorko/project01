package com.demo.leetcode.medium._07_combinations_77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [77. Combinations - MEDIUM](https://leetcode.com/problems/combinations/)
 *
 * - backtracking
 *
 * PRACTICE
 */
public class Combinations {

    @Test
    public void test() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)
        );
        Assertions.assertEquals(expected, combine(4, 2));
    }

    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int k, int s, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = s; i <= n; i++) {
            temp.add(i);
            backtrack(n, k - 1, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
