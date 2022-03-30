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
 */
public class WordBreak2 {

    @Test
    public void test() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cat sand dog", "cats and dog");
        Assertions.assertEquals(expected, wordBreak(s, wordDict));
    }

    Map<String, List<String>> memo;
    Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return wordBreakHelper(s);
    }

    private List<String> wordBreakHelper(final String s) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> ans = new ArrayList<>();

        // 1 <= prefix.length() < s.length()
        for (int i = 1; i < s.length(); ++i) {
            final String prefix = s.substring(0, i);
            final String suffix = s.substring(i);
            if (wordSet.contains(prefix)) {
                for (String word : wordBreakHelper(suffix)) {
                    ans.add(prefix + " " + word);
                }
            }
        }

        // contains whole string, so don't add any space
        if (wordSet.contains(s))
            ans.add(s);

        memo.put(s, ans);
        return ans;
    }
}
