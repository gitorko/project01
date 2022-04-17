package com.demo.leetcode.medium._07_maxlenconcatunq_1239;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1239. Maximum Length of a Concatenated String with Unique Characters - MEDIUM](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/)
 *
 *  - backtracking
 *
 * https://www.youtube.com/watch?v=d4SPuvkaeoo&ab_channel=NeetCode
 */
public class MaxLengthConcatUnique {

    @Test
    public void test1() {
        List<String> arr = Arrays.asList("un", "iq", "ue");
        Assertions.assertEquals(4, maxLength(arr));
    }

    @Test
    public void test2() {
        List<String> arr = Arrays.asList("jnfbyktlrqumowxd", "mvhgcpxnjzrdei");
        Assertions.assertEquals(16, maxLength(arr));
    }

    List<String> arr;
    int result = 0;

    public int maxLength(List<String> arr) {
        this.arr = arr;
        backtrack(0, "");
        return result;
    }

    private void backtrack(int start, String temp) {
        if (hasNoDuplicates(temp)) {
            result = Math.max(result, temp.length());
        }
        if (start == arr.size()) return;

        for (int i = start; i < arr.size(); i++) {
            if (hasNoDuplicates(temp)) {
                backtrack(i + 1, temp + arr.get(i));
            }
        }
    }

    private boolean hasNoDuplicates(String res) {
        Set<Character> charSet = new HashSet<>();
        for (char c : res.toCharArray()) {
            charSet.add(c);
        }
        if (res.length() == charSet.size()) {
            return true;
        }
        return false;
    }
}
