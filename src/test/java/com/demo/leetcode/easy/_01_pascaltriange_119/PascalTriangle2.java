package com.demo.leetcode.easy._01_pascaltriange_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [119. Pascal's Triangle II - EASY](https://leetcode.com/problems/pascals-triangle-ii/)
 *
 * - two for loop
 * - SIMILAR_TO: [118. Pascal's Triangle - EASY](https://leetcode.com/problems/pascals-triangle/)
 */
public class PascalTriangle2 {

    @Test
    public void test() {
        List<Integer> result = getRow(3);
        List<Integer> expected = Arrays.asList(1, 3, 3, 1);
        Assertions.assertEquals(expected, result);
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public List<Integer> getRow(int numRows) {
        numRows = numRows + 1;
        List<List<Integer>> result = new ArrayList<>();
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
        return result.get(numRows - 1);
    }
}
