package com.demo.leetcode.easy._04_laststoneweight_1046;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1046. Last Stone Weight - EASY](https://leetcode.com/problems/last-stone-weight/)
 *
 * - max heap
 *
 * https://www.youtube.com/watch?v=B-QCq79-Vfw&ab_channel=NeetCode
 */
public class LastStoneWeight {

    @Test
    public void test() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Assertions.assertEquals(1, lastStoneWeight(stones));
    }

    /**
     * Time O(n log(n))
     * Space O(n)
     */
    public int lastStoneWeight(int[] stones) {
        //max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int a : stones)
            maxHeap.offer(a);
        while (maxHeap.size() > 1)
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
        return maxHeap.poll();
    }
}
