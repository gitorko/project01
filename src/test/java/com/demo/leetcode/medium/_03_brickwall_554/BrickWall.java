package com.demo.leetcode.medium._03_brickwall_554;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [554. Brick Wall - MEDIUM](https://leetcode.com/problems/brick-wall/)
 *
 * - count gaps
 * - wall size - max
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Kkmv2h48ekw&ab_channel=NeetCode
 */
public class BrickWall {

    @Test
    public void test() {
        Integer[][] wall = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        List<List<Integer>> walls = Arrays.stream(wall).map(Arrays::asList).collect(Collectors.toList());
        Assertions.assertEquals(2, leastBricks(walls));
    }

    /**
     * Time: O(n)
     */
    public int leastBricks(List<List<Integer>> wall) {
        int maxFreq = 0;
        Map<Integer, Integer> countGap = new HashMap<>();

        for (List<Integer> row : wall) {
            int position = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                position += row.get(i);
                countGap.put(position, countGap.getOrDefault(position, 0) + 1);
                //max gaps
                maxFreq = Math.max(maxFreq, countGap.get(position));
            }
        }
        return wall.size() - maxFreq;
    }
}
