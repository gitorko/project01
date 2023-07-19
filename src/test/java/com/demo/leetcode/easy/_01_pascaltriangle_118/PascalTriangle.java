package com.demo.leetcode.easy._01_pascaltriangle_118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [118. Pascal's Triangle - EASY](https://leetcode.com/problems/pascals-triangle/)
 *
 * - SIMILAR_TO: [120. Triangle - MEDIUM](https://leetcode.com/problems/triangle/)
 *
 * https://www.youtube.com/watch?v=nPVEaB3AjUM&ab_channel=NeetCode
 */
public class PascalTriangle {

    @Test
    public void test() {
        List<List<Integer>> generate = generate(5);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1));
        Assertions.assertEquals(expected, generate);
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //fill all rows with 1
        for (int i = 0; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            result.add(Arrays.asList(temp));
        }

        //start from 2, as first 2 rows will always be 1
        for (int i = 2; i < numRows; i++) {
            List<Integer> curRow = result.get(i);
            List<Integer> prevRow = result.get(i - 1);
            //from [1 .. n-1] as borders are always 1
            for (int j = 1; j < curRow.size() - 1; j++) {
                curRow.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }
        }
        return result;
    }
}
