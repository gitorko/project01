package com.demo.leetcode.easy._02_lengthoflastword_58;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [58. Length of Last Word - EASY](https://leetcode.com/problems/length-of-last-word/)
 *
 * https://www.youtube.com/watch?v=KT9rltZTybQ&ab_channel=NeetCode
 */
public class LengthOfLastWord {

    @Test
    public void test() {
        Assertions.assertEquals(5, lengthOfLastWord("Hello World"));
        Assertions.assertEquals(5, lengthOfLastWord("Hello World  "));
    }

    /**
     * Time: O(n)
     */
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        //remove leading white space
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int lastIndex = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return lastIndex - i;
    }
}
