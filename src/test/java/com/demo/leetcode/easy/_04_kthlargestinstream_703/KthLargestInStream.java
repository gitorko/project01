package com.demo.leetcode.easy._04_kthlargestinstream_703;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * [703. Kth Largest Element in a Stream - EASY](https://leetcode.com/problems/kth-largest-element-in-a-stream/)
 *
 * - min heap
 *
 * https://www.youtube.com/watch?v=hOjcdrqMoQ8&ab_channel=NeetCode
 */
public class KthLargestInStream {

    @Test
    public void test() {
        int nums[] = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        Assertions.assertEquals(4, kthLargest.add(3));
        Assertions.assertEquals(5, kthLargest.add(5));
        Assertions.assertEquals(5, kthLargest.add(10));
        Assertions.assertEquals(8, kthLargest.add(9));
        Assertions.assertEquals(8, kthLargest.add(4));
    }

    /**
     * Time: O(n-k) * log(n)
     * option 1: Sort the array each time and use binary search to find the kth largest.
     * option 2: use min heap (priority queue)
     */
    class KthLargest {
        int k;
        PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            //heapify
            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }
            return heap.peek();
        }
    }

}
