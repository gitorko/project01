package com.demo.leetcode.medium._03_threesumclosest_16;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [16. 3Sum Closest - MEDIUM](https://leetcode.com/problems/3sum-closest/)
 *
 * - math.abs
 * - for loop till i-2
 * - SIMILAR_TO: [15. 3Sum - MEDIUM](https://leetcode.com/problems/3sum/)
 * - PRACTICE
 */
public class ThreeSumClosest {

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Assertions.assertEquals(2, threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // choose nums[i] as the first num in the triplet,
            // and search the remaining nums in [i + 1, n - 1]
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == target)
                    return threeSum;
                if (Math.abs(threeSum - target) < Math.abs(result - target))
                    result = threeSum;
                if (threeSum < target)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
