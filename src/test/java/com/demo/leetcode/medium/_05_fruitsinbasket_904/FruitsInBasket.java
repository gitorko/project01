package com.demo.leetcode.medium._05_fruitsinbasket_904;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [904. Fruit Into Baskets - MEDIUM](https://leetcode.com/problems/fruit-into-baskets/)
 *
 * - sliding window + map
 * - longest subarray with 2 distinct elements.
 * - map with size = 2
 * - SIMILAR_TO: [340. Longest Substring with At Most K Distinct Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
 *
 * PRACTICE: P1
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
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            //moment map has more than 2 distinct element check
            while (map.size() > 2) {
                //reduce the count of the left side tree
                map.put(fruits[left], map.get(fruits[left]) - 1);
                //after reducing the count if it becomes 0 remove from the map.
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                //slide the left window forward.
                left++;
            }
            total = Math.max(total, right - left + 1);
        }
        return total;
    }
}
