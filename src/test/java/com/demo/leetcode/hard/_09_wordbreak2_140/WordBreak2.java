package com.demo.leetcode.hard._09_wordbreak2_140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [140. Word Break II - HARD](https://leetcode.com/problems/word-break-ii/)
 *
 *  - set
 *  - memoization in map
 *  - SIMILAR_TO: [139. Word Break - MEDIUM](https://leetcode.com/problems/word-break/)
 */
public class WordBreak2 {

    @Test
    public void test() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cat sand dog", "cats and dog");
        Assertions.assertEquals(expected, wordBreak(s, wordDict));
    }

    /**
     * Time: O(2^n)
     * Space: O(2^n)
     */
    Map<String, List<String>> memo;
    Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return wordBreakHelper(s);
    }

    private List<String> wordBreakHelper(String s) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        // start from 2nd char
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix)) {
                for (String word : wordBreakHelper(suffix)) {
                    result.add(prefix + " " + word);
                }
            }
        }
        // contains whole string, so don't add any space
        if (wordSet.contains(s)) {
            result.add(s);
        }
        memo.put(s, result);
        return result;
    }
}
