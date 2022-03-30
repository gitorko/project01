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
    }

    @Test
    public void test2() {
        int[] nums = {6, 5, 5};
        Assertions.assertEquals(5, majorityElement(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * one pass
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > maxCount) {
                result = nums[i];
            }
            maxCount = Math.max(maxCount, map.get(nums[i]));
        }
        return result;
    }

    /**
     * Boyer-Moore
     * Time: O(n)
     * Space: O(1)
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
