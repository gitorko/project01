package com.demo.leetcode.medium._13_search2dmatrix_74;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [74. Search a 2D Matrix - MEDIUM](https://leetcode.com/problems/search-a-2d-matrix/)
 *
 * - binary search
 * - mid/n , mid%n
 *
 * https://www.youtube.com/watch?v=Ber2pi2C0j0&ab_channel=NeetCode
 */
public class Search2DMatrix {

    @Test
    public void test1() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Assertions.assertTrue(searchMatrix(matrix, target));
        Assertions.assertTrue(searchMatrix2(matrix, target));
    }

    @Test
    public void test2() {
        int[][] matrix = {{1}};
        int target = 1;
        Assertions.assertTrue(searchMatrix(matrix, target));
        Assertions.assertTrue(searchMatrix2(matrix, target));
    }

    @Test
    public void test3() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Assertions.assertTrue(searchMatrix(matrix, target));
        Assertions.assertTrue(searchMatrix2(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int top = 0;
        int bottom = rowLen - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target > matrix[mid][colLen - 1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                break;
            }
        }

        //no match found
        if (!(top <= bottom)) return false;

        int row = (top + bottom) / 2;
        int left = 0;
        int right = colLen - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Time: O(mnlogmn)
     * Space: O(1)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;

        while (left < right) {
            int mid = (left + right) / 2;
            //will work only because range is 2 digit
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return false;
    }
}
