package com.demo.leetcode.medium._06_closedisland_1254;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1254. Number of Closed Islands - MEDIUM](https://leetcode.com/problems/number-of-closed-islands/)
 *
 * https://www.youtube.com/watch?v=X8k48xek8g8&ab_channel=NeetCodeIO
 */
public class ClosedIsland {

    @Test
    public void test() {
        int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        Assertions.assertEquals(0, closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        return 0;
    }

}
