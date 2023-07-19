package com.demo.leetcode.medium._05_longestsubstrwithkdistinct_340;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [159. Longest Substring with At Most Two Distinct Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)
 * [340. Longest Substring with At Most K Distinct Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
 *
 * - https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/
 * - https://www.lintcode.com/problem/386
 * - sliding window + map counter
 * - SIMILAR_TO: [904. Fruit Into Baskets - MEDIUM](https://leetcode.com/problems/fruit-into-baskets/)
 *
 * PRACTICE
 */
public class LongestSubstringKDistinct {

    @Test
    public void test() {
        Assertions.assertEquals(3, lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int total = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                //reduce the count of the left side tree
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                //after reducing the count if it becomes 0 remove from the map.
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            total = Math.max(total, right - left + 1);
        }
        return total;
    }

}
