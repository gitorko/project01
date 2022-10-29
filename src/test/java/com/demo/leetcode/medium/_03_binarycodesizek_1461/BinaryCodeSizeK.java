package com.demo.leetcode.medium._03_binarycodesizek_1461;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1461. Check If a String Contains All Binary Codes of Size K - MEDIUM](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/)
 *
 * - set
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=qU32rTy_kOM&ab_channel=NeetCode
 */
public class BinaryCodeSizeK {

    @Test
    public void test() {
        Assertions.assertTrue(hasAllCodes("00110110", 2));
    }

    /**
     * Time: O(nk)
     * Space: O(nk)
     */
    public boolean hasAllCodes(String s, int k) {
        Set<String> codeSet = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            codeSet.add(s.substring(i, i + k));
        }
        return codeSet.size() == Math.pow(2, k);
    }
}
