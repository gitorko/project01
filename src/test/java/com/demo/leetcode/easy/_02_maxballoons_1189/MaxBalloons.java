package com.demo.leetcode.easy._02_maxballoons_1189;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1189. Maximum Number of Balloons - EASY](https://leetcode.com/problems/maximum-number-of-balloons/)
 *
 * - two map
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=G9xeB2-7PqY&ab_channel=NeetCode
 */
public class MaxBalloons {

    @Test
    public void test() {
        String text = "nlaebolko";
        Assertions.assertEquals(1, maxNumberOfBalloons(text));
    }

    /**
     * Space: O(n)
     * Time: O(1) as char set is 26.
     * Make it generic enough so that if word balloon is changed to ballooon (odd length 'o') then also code should work.
     * Most solutions divide by 2, test will fail if word is made of odd length chars.
     */
    public int maxNumberOfBalloons(String text) {
        String word = "balloon";
        //initialize word map
        int[] wordcount = new int[26];
        for (char c : word.toCharArray()) {
            wordcount[c - 'a']++;
        }

        //initialize map
        int[] chars = new int[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }

        //instead of max set to input text length
        int result = text.length();
        for (char c : word.toCharArray()) {
            result = Math.min(result, chars[c - 'a'] / wordcount[c - 'a']);
        }
        return result;
    }

}
