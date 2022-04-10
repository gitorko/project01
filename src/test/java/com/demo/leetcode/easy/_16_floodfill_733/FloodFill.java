package com.demo.leetcode.easy._16_floodfill_733;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [733. Flood Fill - EASY](https://leetcode.com/problems/flood-fill/)
 */
public class FloodFill {

    @Test
    public void test() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] expected = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        Assertions.assertArrayEquals(expected, floodFill(image, 1, 1, 2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    boolean[][] seen;
    int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        seen = new boolean[image.length][image[0].length];
        dfs(sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int i, int j, int startColor, int newColor) {
        if (i < 0 || j < 0 || i == image.length || j == image[0].length || seen[i][j] || image[i][j] != startColor)
            return;

        image[i][j] = newColor;
        seen[i][j] = true;

        dfs(i + 1, j, startColor, newColor);
        dfs(i - 1, j, startColor, newColor);
        dfs(i, j + 1, startColor, newColor);
        dfs(i, j - 1, startColor, newColor);
    }
}
