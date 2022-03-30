package com.demo.leetcode.medium._07_subset_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [78. Subsets - MEDIUM](https://leetcode.com/problems/subsets/)
 *
 * - backtracking, i+1
 *
 * https://www.youtube.com/watch?v=REOH22Xwdkk&ab_channel=NeetCode
 */
public class Subset {

    @Test
    public void test() {
        int nums[] = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(Collections.emptyList()
                , Arrays.asList(1)
                , Arrays.asList(1, 2)
                , Arrays.asList(1, 2, 3)
                , Arrays.asList(1, 3)
                , Arrays.asList(2)
                , Arrays.asList(2, 3)
                , Arrays.asList(3));
        Assertions.assertEquals(expected, subsets(nums));
    }

    @Test
    public void test2() {
        int nums[] = {1, 2};
        List<List<Integer>> expected = Arrays.asList(Collections.emptyList()
                , Arrays.asList(1)
                , Arrays.asList(1, 2)
                , Arrays.asList(2));
        Assertions.assertEquals(expected, subsets(nums));
    }

    /**
     * Time: O(2^n)
     * Space: O(2^n)
     */
    int[] nums;
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] input) {
        nums = input;
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<Integer> tempList, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
