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
 *
 * PRACTICE
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

    public List<List<String>> partition(String input) {
        this.s = input;
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(List<String> tempList, int start) {
        if (start == s.length())
            result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(tempList, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
