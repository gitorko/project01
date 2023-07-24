package com.demo.leetcode.medium._07_combinationsum1_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [39. Combination Sum - MEDIUM](https://leetcode.com/problems/combination-sum/)
 *
 * - backtracking
 * - SIMILAR_TO: [40. Combination Sum II - MEDIUM](https://leetcode.com/problems/combination-sum-ii/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=GBKI9VSKdGg&ab_channel=NeetCode
 */
public class CombinationSum {

    @Test
    public void test() {
        int candidates[] = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7));
        Assertions.assertEquals(expected, combinationSum(candidates, target));
    }

    /**
     * Time: O(2^target)
     * Space: O(target)
     */
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        result = new ArrayList<>();
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
                tempList.add(nums[i]);
                //Remember to not i + 1 because we can reuse same elements
                backtrack(tempList, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
