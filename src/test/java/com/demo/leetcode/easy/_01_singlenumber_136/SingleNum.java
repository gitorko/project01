package com.demo.leetcode.easy._01_singlenumber_136;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [136. Single Number - EASY](https://leetcode.com/problems/single-number/)
 *
 * - XOR, 0^0=0, 1^1 = 0
 *
 * https://www.youtube.com/watch?v=qMPX1AOa83k&ab_channel=NeetCode
 */
public class SingleNum {

    @Test
    public void test() {
        int arr[] = {4, 1, 2, 1, 2};
        Assertions.assertEquals(4, singleNumber(arr));
        Assertions.assertEquals(4, singleNumberMath(arr));
        Assertions.assertEquals(4, singleNumberBit(arr));
        Assertions.assertEquals(4, singleNumberBitLambda(arr));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int singleNumberBit(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a = a ^ i;
        }
        return a;
    }

    public int singleNumberBitLambda(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, i) -> a ^ i);
    }

    /**
     * using map
     * Time: O(N)
     * Space: O(N)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i : nums) {
            resultMap.put(i, resultMap.getOrDefault(i, 0) + 1);
        }
        return resultMap.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findAny()
                .get();
    }

    /**
     * Math: 2∗(a+b+c)−(a+a+b+b+c)=c
     *
     * Set will have all numbers once, so multiply by 2 and subtract by sum of all nums
     *
     * Time: O(N)
     * Space: O(N)
     */
    public int singleNumberMath(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }

}
