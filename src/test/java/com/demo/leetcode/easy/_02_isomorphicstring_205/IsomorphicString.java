package com.demo.leetcode.easy._02_isomorphicstring_205;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [205. Isomorphic Strings - EASY](https://leetcode.com/problems/isomorphic-strings/)
 *
 * - two map
 * - SIMILAR_TO: [290. Word Pattern - EASY](https://leetcode.com/problems/word-pattern/)
 *
 * https://www.youtube.com/watch?v=7yF-U1hLEqQ&ab_channel=NeetCode
 */
public class IsomorphicString {

    @Test
    public void test1() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isIsomorphic("foo", "bar"));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isIsomorphic("ff", "ba"));
    }

    /**
     * Time: O(n)
     * Space: O(128) = O(1)
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) != null && sMap.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (tMap.get(t.charAt(i)) != null && tMap.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            sMap.put(s.charAt(i), t.charAt(i));
            tMap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
