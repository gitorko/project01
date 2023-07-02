package com.demo.leetcode.easy._02_longcommonprefix_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [14. Longest Common Prefix - EASY](https://leetcode.com/problems/longest-common-prefix/)
 *
 * - treat the first word as result and compare with rest of 1..n
 * - first loop on char, 2nd on words
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=0sWShKIJoo4&ab_channel=NeetCode
 */
public class LongestCommonPrefixString {

    @Test
    public void test1() {
        String[] arr = {"flower", "flow", "flight"};
        Assertions.assertEquals("fl", longestCommonPrefix(arr));
    }

    @Test
    public void test2() {
        String[] arr = {"dog", "racecar", "car"};
        Assertions.assertEquals("", longestCommonPrefix(arr));
    }

    /**
     * Time: O(m * n) n=string element, m = avg size of each string
     * Space: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //Here we are taking length of first string,
        //it can be possible other strings are shorter/longer than first string.
        //Because we are treating the first string as result we are comparing with rest of the string.
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            //For each word other than first word.
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
