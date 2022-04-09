package com.demo.leetcode.easy._03_wordpattern_290;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [290. Word Pattern - EASY](https://leetcode.com/problems/word-pattern/)
 *
 * - use 2 map
 * - SIMILAR_TO: [205. Isomorphic Strings - EASY](https://leetcode.com/problems/isomorphic-strings/)
 *
 * https://www.youtube.com/watch?v=W_akoecmCbM&ab_channel=NeetCode
 */
public class WordPattern {

    @Test
    public void test() {
        Assertions.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog cat cat fish"));
    }

    /**
     * Time: O(m+n)
     * Space: O(m+n)
     */
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        //edge case when both length dont match
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (charToWord.get(c) != null && !charToWord.get(c).equals(word)) {
                return false;
            }
            if (wordToChar.get(word) != null && wordToChar.get(word) != c) {
                return false;
            }
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }
        return true;
    }
}
