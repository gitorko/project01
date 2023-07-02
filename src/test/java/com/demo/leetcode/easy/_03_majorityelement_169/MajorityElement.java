package com.demo.leetcode.easy._03_majorityelement_169;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [169. Majority Element - EASY](https://leetcode.com/problems/majority-element/)
 *
 * - map and count
 * - Boyer-Moore Voting Algorithm Time: O(n)
 *
 * https://www.youtube.com/watch?v=7pnhv842keE&ab_channel=NeetCode
 */
public class MajorityElement {

    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        Assertions.assertEquals(3, majorityElement(nums));
        Assertions.assertEquals(3, majorityElement2(nums));
    }

    @Test
    public void test2() {
        int[] nums = {6, 5, 5};
        Assertions.assertEquals(5, majorityElement(nums));
        Assertions.assertEquals(5, majorityElement2(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * one pass
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        int majority = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0) + 1);
            if (mapCount.get(nums[i]) > maxCount) {
                majority = nums[i];
                maxCount = mapCount.get(nums[i]);
            }
        }
        return majority;
    }

    /**
     * Boyer-Moore
     * Time: O(n)
     * Space: O(1)
     */
    public int majorityElement2(int[] nums) {
        int majority = nums[0];
        int count = 1;
        //start from 2nd element
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
