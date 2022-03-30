package com.demo.leetcode.medium._05_reversewordsinstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [151. Reverse Words in a String - MEDIUM](https://leetcode.com/problems/reverse-words-in-a-string/)
 *
 * - two pointer
 */
public class ReverseWordsInString {

    @Test
    public void test() {
        Assertions.assertEquals("blue is sky the", reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--) {
            result.append(parts[i]).append(" ");
        }
        return result.append(parts[0]).toString();
    }
}
