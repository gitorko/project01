package com.demo.leetcode.medium._05_frequenceyofmostfrequent;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1838. Frequency of the Most Frequent Element - MEDIUM](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)
 *
 * - sort + sliding window
 * - nums[right] * windowSize > total + k
 * - SIMILAR_TO: [424. Longest Repeating Character Replacement - MEDIUM](https://leetcode.com/problems/longest-repeating-character-replacement/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=vgBrQ0NM5vE&ab_channel=NeetCode
 */
public class FrequencyOfMostFrequent {

    @Test
    public void test() {
        int[] nums = {1, 2, 4};
        Assertions.assertEquals(3, maxFrequency(nums, 5));
    }

    /**
     * Time: O(n * log(n))
     * Space: O(1)
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = 0;
        long total = 0;
        while (right < nums.length) {
            total += nums[right];
            int windowSize = right - left + 1;
            //if budget is exceeded then reduce window
            while (nums[right] * windowSize > total + k) {
                total -= nums[left];
                left++;
            }
            result = Math.max(result, windowSize);
            right++;
        }
        return result;
    }
}
