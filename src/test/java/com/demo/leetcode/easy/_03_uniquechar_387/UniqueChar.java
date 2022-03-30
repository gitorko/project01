package com.demo.leetcode.easy._03_uniquechar_387;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [387. First Unique Character in a String - EASY](https://leetcode.com/problems/first-unique-character-in-a-string/)
 *
 * - map count
 */
public class UniqueChar {

    @Test
    public void test() {
        Assertions.assertEquals(0, firstUniqChar("leetcodeABC"));
    }

    /**
     * Time: O(n)
     * Space: O(128) = O(1)
     */
    public int firstUniqChar(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c - 'A']++;

        for (int i = 0; i < s.length(); ++i)
            if (count[s.charAt(i) - 'A'] == 1)
                return i;

        return -1;
    }
}
