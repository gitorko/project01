package com.demo.leetcode.easy._02_isomorphicstring_205;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [205. Isomorphic Strings - EASY](https://leetcode.com/problems/isomorphic-strings/)
 *
 * - two map
 *
 * https://www.youtube.com/watch?v=7yF-U1hLEqQ&ab_channel=NeetCode
 */
public class IsomorphicString {

    @Test
    public void test() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
    }

    /**
     * Time: O(n)
     * Space: O(128) = O(1)
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> charToIndex_s = new HashMap<>();
        Map<Character, Integer> charToIndex_t = new HashMap<>();

        for (Integer i = 0; i < s.length(); i++)
            if (charToIndex_s.put(s.charAt(i), i) != charToIndex_t.put(t.charAt(i), i))
                return false;

        return true;
    }
}
