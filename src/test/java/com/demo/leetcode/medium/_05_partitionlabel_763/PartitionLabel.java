package com.demo.leetcode.medium._05_partitionlabel_763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [763. Partition Labels - MEDIUM](https://leetcode.com/problems/partition-labels/)
 *
 * - two pointer
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=B7m8UmZE-vw&ab_channel=NeetCode
 */
public class PartitionLabel {

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(9, 7, 8);
        Assertions.assertEquals(expected, partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(10);
        Assertions.assertEquals(expected, partitionLabels("eccbbbbdec"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] rightmost = new int[26];

        //last index of char
        for (int i = 0; i < s.length(); i++)
            rightmost[s.charAt(i) - 'a'] = i;

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, rightmost[s.charAt(i) - 'a']);
            if (right == i) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}
