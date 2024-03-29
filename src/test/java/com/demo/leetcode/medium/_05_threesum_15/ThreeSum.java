package com.demo.leetcode.medium._05_threesum_15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [15. 3Sum - MEDIUM](https://leetcode.com/problems/3sum/)
 *
 * - sort, two pointer needs sorted array
 * - SIMILAR_TO: [16. 3Sum Closest - MEDIUM](https://leetcode.com/problems/3sum-closest/)
 * - SIMILAR_TO: [18. 4Sum - MEDIUM](https://leetcode.com/problems/4sum/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=jzZsG8n2R9A&ab_channel=NeetCode
 */
public class ThreeSum {

    @Test
    public void test() {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        Assertions.assertEquals(expected, threeSum(nums));
    }

    @Test
    public void test2() {
        int nums[] = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2, 0, 2));
        Assertions.assertEquals(expected, threeSum(nums));
    }

    /**
     * Sort, skip if previous adjacent is same.
     * Time: O(n^2)
     * Space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        //important for outer loop till n-2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // skip same result
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    //Since there are duplicates the left number can be same.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (threeSum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
