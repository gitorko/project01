package com.demo.leetcode.hard._12_disjointinterval_352;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [352. Data Stream as Disjoint Intervals - HARD](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)
 *
 * - TreeMap
 *
 * https://www.youtube.com/watch?v=FavoZjPIWpo&ab_channel=NeetCodeIO
 */
public class DisjoinInterval {

    @Test
    public void test() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        int[][] expected = new int[][]{{1, 1}};// arr = [1]
        Assertions.assertArrayEquals(new int[][]{{1, 1}}, summaryRanges.getIntervals()); // return [[1, 1]]

        summaryRanges.addNum(3);      // arr = [1, 3]
        Assertions.assertArrayEquals(new int[][]{{1, 1}, {3, 3}}, summaryRanges.getIntervals()); // return [[1, 1], [3, 3]]

        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        Assertions.assertArrayEquals(new int[][]{{1, 1}, {3, 3}, {7, 7}}, summaryRanges.getIntervals()); // return [[1, 1], [3, 3]][7, 7]]

        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        Assertions.assertArrayEquals(new int[][]{{1, 3}, {7, 7}}, summaryRanges.getIntervals()); // return [[1, 3], [7, 7]]

        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        Assertions.assertArrayEquals(new int[][]{{1, 3}, {6, 7}}, summaryRanges.getIntervals()); // return [[1, 3], [6, 7]]
    }

    class SummaryRanges {
        TreeMap<Integer, int[]> map;

        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            if (map.containsKey(val)) {
                return;
            }
            Integer left = map.lowerKey(val);
            Integer right = map.higherKey(val);
            if (left != null && right != null && map.get(left)[1] + 1 == val && right == val + 1) {
                map.get(left)[1] = map.get(right)[1];
                map.remove(right);
            } else if (left != null && map.get(left)[1] + 1 >= val) {
                map.get(left)[1] = Math.max(map.get(left)[1], val);
            } else if (right != null && right == val + 1) {
                map.put(val, new int[]{val, map.get(right)[1]});
                map.remove(right);
            } else {
                map.put(val, new int[]{val, val});
            }
        }

        public int[][] getIntervals() {
            List<int[]> intervals = new ArrayList<>(map.values());
            return intervals.toArray(new int[intervals.size()][]);
        }
    }
}
