package com.demo.leetcode.medium._07_permutationnumber1_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [46. Permutations - MEDIUM](https://leetcode.com/problems/permutations/)
 *
 * - backtracking, visited to avoid duplicates
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=s7AvT7cGdSo&ab_channel=NeetCode
 */
public class PermutationsNumber {

    @Test
    public void test() {
        int nums[] = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1));
        Assertions.assertEquals(expected, permute(nums));
    }

    @Test
    public void test2() {
        int nums[] = {1, 2};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1));
        Assertions.assertEquals(expected, permute(nums));
    }

    /**
     * Time: O(n * n!)
     * Space: O(n * n!)
     */
    int[] nums;
    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permute(int[] input) {
        this.nums = input;
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        backtrack(new ArrayList<>());
        return result;
    }

    private void backtrack(List<Integer> tempResult) {
        if (tempResult.size() == nums.length) {
            result.add(new ArrayList<>(tempResult));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                tempResult.add(nums[i]);
                visited[i] = true;
                backtrack(tempResult);
                tempResult.remove(tempResult.size() - 1);
                visited[i] = false;
            }
        }
    }
}
