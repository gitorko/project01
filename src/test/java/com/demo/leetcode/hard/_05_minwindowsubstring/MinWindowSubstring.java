package com.demo.leetcode.hard._05_minwindowsubstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [76. Minimum Window Substring - HARD](https://leetcode.com/problems/minimum-window-substring/)
 *
 * - have, need map, sliding window 2 pointer
 * - SIMILAR_TO: [28. Implement strStr - MEDIUM](https://leetcode.com/problems/implement-strstr/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=jSto0O4AJbM&ab_channel=NeetCode
 */
public class MinWindowSubstring {

    @Test
    public void test1() {
        Assertions.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("aa", minWindow("aa", "aa"));
    }

    /**
     * Time: O(∣s∣+∣t∣)
     * Space: O(128) = O(1)
     */
    public String minWindow(String s, String t) {
        int[] countT = new int[128];
        int[] window = new int[128];
        int need = 0;
        int have = 0;

        for (char c : t.toCharArray()) {
            countT[c]++;
            //each char counts once for need, exact count is matched later.
            if (countT[c] == 1) {
                need++;
            }
        }

        int leftStart = -1;
        int minLength = s.length() + 1;

        for (int left = 0, right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            window[c]++;
            if (countT[c] != 0 && window[c] == countT[c]) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < minLength) {
                    leftStart = left;
                    minLength = right - left + 1;
                }
                window[s.charAt(left)]--;
                if (countT[c] != 0 && window[s.charAt(left)] < countT[s.charAt(left)]) {
                    have--;
                }
                left++;
            }
        }
        return leftStart == -1 ? "" : s.substring(leftStart, leftStart + minLength);
    }
}
