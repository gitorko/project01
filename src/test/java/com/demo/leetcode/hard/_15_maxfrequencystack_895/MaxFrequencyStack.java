package com.demo.leetcode.hard._15_maxfrequencystack_895;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [895. Maximum Frequency Stack - HARD](https://leetcode.com/problems/maximum-frequency-stack/)
 *
 * - count map + map of stack
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Z6idIicFDOE&ab_channel=NeetCode
 */
public class MaxFrequencyStack {

    @Test
    public void test() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        Assertions.assertEquals(5, freqStack.pop());
        // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        Assertions.assertEquals(7, freqStack.pop());
        // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        Assertions.assertEquals(5, freqStack.pop());
        // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
        Assertions.assertEquals(4, freqStack.pop());
    }

    /**
     * Time: O(1)
     */
    class FreqStack {
        int maxFreq = 0;
        //[val, sum]
        Map<Integer, Integer> freqMap = new HashMap<>();
        //[sum, values]
        Map<Integer, Stack<Integer>> countToStack = new HashMap<>();

        public void push(int val) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(val));
            countToStack.putIfAbsent(freqMap.get(val), new Stack<>());
            countToStack.get(freqMap.get(val)).push(val);
        }

        public int pop() {
            int val = countToStack.get(maxFreq).pop();
            freqMap.put(val, freqMap.getOrDefault(val, 0) - 1);
            if (countToStack.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            return val;
        }
    }
}
