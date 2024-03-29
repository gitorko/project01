package com.demo.leetcode.medium._01_foursum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [18. 4Sum - MEDIUM](https://leetcode.com/problems/4sum/)
 *
 * - backtracking + two sum
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=EYeR-_1NRlQ&ab_channel=NeetCode
 */
public class FourSum {

    @Test
    public void test1() {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 2, 2, 2));
        Assertions.assertEquals(expected, fourSum(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2), Arrays.asList(-1, 0, 0, 1));
        Assertions.assertEquals(expected, fourSum(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> expected = Collections.emptyList();
        Assertions.assertEquals(expected, fourSum(nums, target));
    }

    /**
     * Time: O(n^3)
     * Space: O(n)
     */
    List<List<Integer>> result;
    int[] nums;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        Arrays.sort(nums);
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), target, 0, 4);
        return result;
    }

    public void backtrack(ArrayList<Integer> tempList, long target, int start, int k) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                //remove duplicate combinations
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(tempList, target - nums[i], i + 1, k - 1);
                tempList.remove(tempList.size() - 1);
            }
        } else {
            //two sum
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    //dont modify tempList
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(tempList);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    //advance left else will be stuck in loop
                    left++;
                    //skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
    }
}
