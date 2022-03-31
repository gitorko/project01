package com.demo.leetcode.medium._07_uniquebinarystring_1980;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1980. Find Unique Binary String - MEDIUM](https://leetcode.com/problems/find-unique-binary-string/)
 *
 * - Cantor's diagonal
 *
 * https://www.youtube.com/watch?v=aHqn4Dynd1k&ab_channel=NeetCode
 */
public class UniqueBinaryString {

    @Test
    public void test() {
        String[] nums = {"01", "10"};
        Assertions.assertEquals("11", findDifferentBinaryString(nums));
    }

    /**
     * Time: O(n)
     * Space:O(1)
     *
     * Since we are given that number of bits in the number is equal to number of elements.
     * Create a binary string which differs from first binary at 1st position, second binary at 2nd position, third binary at 3rd position
     * This will make sure that the binary we have made is unique (as it differs from all others at atleast one position).
     */
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return ans.toString();
    }
}
