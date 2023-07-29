package com.demo.leetcode.medium._07_permutationnumber2_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [47. Permutations II - MEDIUM](https://leetcode.com/problems/permutations-ii/)
 *
 * - sort, backtracking
 * - SIMILAR_TO: [46. Permutations - MEDIUM](https://leetcode.com/problems/permutations/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=s7AvT7cGdSo&ab_channel=NeetCode
 */
public class PermutationsNumberHasDuplicates {

    @Test
    public void test() {
        int nums[] = {1, 1, 2};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 1, 2),
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 1, 1));
        Assertions.assertEquals(expected, permuteUnique(nums));
    }

    /**
     * Time: O(n * n!)
     * Space: O(n * n!)
     */
    List<List<Integer>> result;
    int[] nums;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>());
        return result;
    }

    public void backtrack(List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    // case to avoid duplicates.
                    // if the numbers are same, if previous identical number is used, then use the current number.
                    // if the numbers are same, if previous identical number was not used, then cant use current number.
                    if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                        continue;
                    }
                    tempList.add(nums[i]);
                    visited[i] = true;
                    backtrack(tempList);
                    visited[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
