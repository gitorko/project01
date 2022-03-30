package com.demo.leetcode.medium._03_pairsum;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

public class PairSum {

//    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 3};
        Assertions.assertEquals(2, numberOfWays(arr, 6));
    }

//    @Test
    public void test2() {
        int[] arr = {1, 5, 3, 3, 3};
        Assertions.assertEquals(4, numberOfWays(arr, 6));
    }

    int numberOfWays(int[] arr, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i];
            //Extra check to see if the complement is not the number itself.
            if (map.containsKey(complement)) {
                result += map.get(complement);
                if (map.get(complement) == i && map.get(complement) > 0) {
                    result--;
                }
                map.put(complement, map.get(complement) - 1);
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }
        return result;

    }
}
