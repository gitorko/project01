package com.demo.leetcode.medium._07_combinationsum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [40. Combination Sum II - MEDIUM](https://leetcode.com/problems/combination-sum-ii/)
 *
 * - sort + backtracking
 * - i + 1
 */
public class CombinationSum2 {

    @Test
    public void test() {
        int candidates[] = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(5));
        Assertions.assertEquals(expected, combinationSum2(candidates, target));
    }

    List<List<Integer>> result;
    int[] nums;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        nums = candidates;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), target, 0);
        return result;
    }

    private void backtrack(List<Integer> tempList, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(tempList, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
