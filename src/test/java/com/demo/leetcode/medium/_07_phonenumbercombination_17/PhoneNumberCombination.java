package com.demo.leetcode.medium._07_phonenumbercombination_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [17. Letter Combinations of a Phone Number - MEDIUM](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 *
 * - backtrack
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=0snEunUacZY&ab_channel=NeetCode
 */
public class PhoneNumberCombination {

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertEquals(expected, letterCombinations("23"));
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList();
        Assertions.assertEquals(expected, letterCombinations(""));
    }

    /**
     * Time: O(n*4^n)
     * Space: O(4^n)
     */
    Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");
    List<String> result;
    String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        result = new ArrayList<>();
        backtrack(0, "");
        return result;
    }

    private void backtrack(int i, String currStr) {
        //when current string length is same as input add to result
        if (currStr.length() == digits.length()) {
            result.add(currStr);
            //remember to return
            return;
        }
        char digit = digits.charAt(i);
        for (Character ch : map.get(digit).toCharArray()) {
            backtrack(i + 1, currStr + ch);
        }
    }

}
