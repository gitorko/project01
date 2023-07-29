package com.demo.leetcode.medium._03_groupanagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [49. Group Anagrams - MEDIUM](https://leetcode.com/problems/group-anagrams/)
 *
 * - map that stores char + list of string
 * - String.valueOf(charCount)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=vzdNOK2oB2E&ab_channel=NeetCode
 */
public class GroupAnagrams {

    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("tan", "nat"),
                Arrays.asList("eat", "tea", "ate")
        );
        Assertions.assertTrue(expected.containsAll(groupAnagrams(strs)));
    }

    /**
     * Time: O(m * n) - m is number of string, n is avg length of each string
     * Space: O(m * n)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charMap = new char[26];
            for (char c : s.toCharArray()) {
                charMap[c - 'a']++;
            }
            String keyStr = String.valueOf(charMap);
            List<String> tempList = map.getOrDefault(keyStr, new ArrayList<>());
            tempList.add(s);
            map.put(keyStr, tempList);
        }
        return new ArrayList<>(map.values());
    }
}
