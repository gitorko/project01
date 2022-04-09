package com.demo.leetcode.medium._07_subset2_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [90. Subsets II - MEDIUM](https://leetcode.com/problems/subsets-ii/)
 *
 * - backtracking
 * - sort and skip duplicates,i+1
 *
 * https://www.youtube.com/watch?v=Vn2v6ajA7U0&ab_channel=NeetCode
 */
public class SubsetHasDuplicates {

    @Test
    public void test() {
        int nums[] = {1, 2, 2};
        List<List<Integer>> expected = Arrays.asList(Collections.emptyList()
                , Arrays.asList(1)
                , Arrays.asList(1, 2)
                , Arrays.asList(1, 2, 2)
                , Arrays.asList(2)
                , Arrays.asList(2, 2));
        Assertions.assertEquals(expected, subsetsWithDup(nums));
    }

    /**
     * Time: O(n * 2^n)
     */
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] input) {
        result = new ArrayList<>();
        nums = input;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<Integer> tempList, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;
            tempList.add(nums[i]);
            backtrack(tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
