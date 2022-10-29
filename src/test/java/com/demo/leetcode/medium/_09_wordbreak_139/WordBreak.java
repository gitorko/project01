package com.demo.leetcode.medium._09_wordbreak_139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [139. Word Break - MEDIUM](https://leetcode.com/problems/word-break/)
 *
 * - option1: dp, start from reverse
 * - break when dp[i] true
 * - option2: can be solved by bfs
 * - SIMILAR_TO: [55. Jump Game - MEDIUM](https://leetcode.com/problems/jump-game/)
 * - SIMILAR_TO: [140. Word Break II - HARD](https://leetcode.com/problems/word-break-ii/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=Sx9NNgInc3A&ab_channel=NeetCode
 */
public class WordBreak {

    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Assertions.assertTrue(wordBreak(s, wordDict));
        Assertions.assertTrue(wordBreak2(s, wordDict));
        Assertions.assertTrue(wordBreak3(s, wordDict));
    }

    @Test
    public void test2() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        Assertions.assertFalse(wordBreak(s, wordDict));
        Assertions.assertFalse(wordBreak2(s, wordDict));
        Assertions.assertFalse(wordBreak3(s, wordDict));
    }

    /**
     * Time: O(n * m * n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //base case
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                //once dp[i] becomes true no need to check the remaining words.
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    /**
     * Recursion with Memoization
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }

    /**
     * BFS approach
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        //when the whole word is present in dict
        if (dict.contains(s)) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        // use a set to record checked index to avoid repeated work.
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = index + 1; i <= s.length(); i++) {
                if (visited.contains(i)) {
                    continue;
                }
                if (dict.contains(s.substring(index, i))) {
                    if (i == s.length())
                        return true;
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }

}
