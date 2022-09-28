package com.demo.leetcode.medium._07_palindromepartition_131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [131. Palindrome Partitioning - MEDIUM](https://leetcode.com/problems/palindrome-partitioning/)
 *
 * - backtracking + check palindrome
 * - SIMILAR_TO: [132. Palindrome Partitioning II - HARD](https://leetcode.com/problems/palindrome-partitioning-ii/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=3jvWodd7ht0&ab_channel=NeetCode
 */
public class PalindromePartition {

    @Test
    public void test() {
        List<List<String>> expected = Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"));
        List<List<String>> result = partition("aab");
        Assertions.assertEquals(expected, result);
    }

    /**
     * Time: O(n*2^n)
     */
    List<List<String>> result;
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        result = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        return result;
    }

    public void backtrack(int start, List<String> tempList) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(i + 1, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
