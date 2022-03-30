package com.demo.leetcode.medium._01_findpair_532;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Pair with diff - MEDIUM]()
 *
 * - Given two arrays of integers a and b of the same length,
 * - find the number of pairs (i, j) such that i <=j and a[i] - b[j] = a[j] - b[i].
 */
public class FindPair {

    @Test
    public void test() {
        int[] a = {2, -2, 5, 3};
        int[] b = {1, 5, -1, 1};
        Assertions.assertEquals(6, getPairCount(a, b));
    }

    /**
     * https://leetcode.com/discuss/interview-question/1719834/Meta-coding-question-2022
     *
     * For a= [2, -2, 5, 3] and b= [1, 5, -1, 1], the output should be solution (a, b) = 6.
     *
     * Reduce the Equation to a[i] + b[i] = a[j] + b[j]
     * Use HashMap to count the (a[i] + b[i]) sum.
     * Initialize the return variable to n. (Because i<=j, means, a[i] + b[i] == a[j] + b[j] for i == j)
     * Add the count of the sum (a[i] + b[i]) to the answer.
     * Return the answer.
     */
    public int getPairCount(int[] a, int[] b) {
        Map<Integer, Integer> seenSums = new HashMap<>();
        int count = a.length;
        for (int i = 0; i < a.length; i++) {
            int x = a[i] + b[i];
            if (seenSums.containsKey(x)) {
                count += seenSums.get(x);
            } else {
                seenSums.put(x, seenSums.getOrDefault(x, 0) + 1);
            }
        }
        return count;
    }
}
