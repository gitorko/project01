package com.demo.leetcode.easy._02_fizzbuzzjazz_412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [412. Fizz Buzz - EASY](https://leetcode.com/problems/fizz-buzz/)
 *
 * - avoid hard coding logic
 */
public class FizzBuzzJazz {

    @Test
    public void test1() {
        List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "Jazz", "8", "Fizz", "Buzz", "11", "Fizz", "13", "Jazz", "FizzBuzz");
        Assertions.assertEquals(expected, fizzBuzz(15));
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "Jazz", "8", "Fizz", "Buzz", "11", "Fizz", "13", "Jazz", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz", "FizzJazz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "Jazz", "29", "FizzBuzz", "31", "32", "Fizz", "34", "BuzzJazz", "Fizz", "37", "38", "Fizz", "Buzz", "41", "FizzJazz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "Jazz", "Buzz");
        Assertions.assertEquals(expected, fizzBuzz(50));
    }

    @Test
    public void test3() {
        List<String> expected = Arrays.asList("1");
        Assertions.assertEquals(expected, fizzBuzz(1));
    }

    public List<String> fizzBuzz(int n) {
        Map<Integer, String> map = new HashMap<>() {{
            put(3, "Fizz");
            put(5, "Buzz");
            put(7, "Jazz");
        }};
        List<String> result = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";

            for (Integer key : map.keySet()) {
                // If the num is divisible by key,
                // then add the corresponding string mapping
                if (num % key == 0) {
                    numAnsStr += map.get(key);
                }
            }

            if (numAnsStr.isBlank()) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }
            result.add(numAnsStr);
        }
        return result;
    }
}
