package com.demo.leetcode.medium._05_fruitsinbasket_904;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [904. Fruit Into Baskets - MEDIUM](https://leetcode.com/problems/fruit-into-baskets/)
 *
 * - sliding window + map
 * - SIMILAR_TO: [340. Longest Substring with At Most K Distinct Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
 * - SIMILAR_TO: [longest subarray with 2 distinct elements]
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=yYtaV0G3mWQ&ab_channel=NeetCodeIO
 */
public class FruitsInBasket {

    @Test
    public void test() {
        int arr[] = {0, 1, 2, 2};
        Assertions.assertEquals(totalFruit(arr), 3);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitMap = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right], 0) + 1);
            //moment fruitMap has more than 2 distinct element check
            while (fruitMap.size() > 2) {
                //reduce the count of the left side tree
                fruitMap.put(fruits[left], fruitMap.get(fruits[left]) - 1);
                //after reducing the count if it becomes 0 remove from the fruitMap.
                if (fruitMap.get(fruits[left]) == 0) {
                    fruitMap.remove(fruits[left]);
                }
                //slide the left window forward.
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
