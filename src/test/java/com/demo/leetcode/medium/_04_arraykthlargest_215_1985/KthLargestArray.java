package com.demo.leetcode.medium._04_arraykthlargest_215_1985;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [215. Kth Largest Element in an Array - MEDIUM](https://leetcode.com/problems/kth-largest-element-in-an-array/)
 * [1985. Find the Kth Largest Integer in the Array - MEDIUM](https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/)
 *
 * - quick select
 * - option 1: Sort array in O(n*log(n)) and return length-k
 * - option 2: Use min heap (priority queue)
 * - option 3: quick select
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=XEmy13g1Qxc&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=lRCaNiqO3xI&ab_channel=NeetCode
 */
public class KthLargestArray {

    @Test
    public void test1() {
        int nums[] = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        Assertions.assertEquals(5, findKthLargest(nums, k));
    }

    @Test
    public void test2() {
        int nums[] = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Assertions.assertEquals(4, findKthLargest(nums, k));
    }

    /**
     * Sort and then use index to find the kth largest.
     *
     * Time: O(n*log(n)) running time
     * Space: O(1) memory
     */
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }

    /**
     * min-heap - heap all elements in O(N) then pop k times so each pop on heap takes log(n) so k*log(n)
     * You can also pop while adding to heap so need another loop.
     *
     * Time: O(k * log(n))
     * Space: O(k)
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * Quick-select
     *
     * Time: O(n), WorstCase: O(n^2)
     * Space: O(1)
     * Quicksort time complexity is O(n*log(n)) but here we look at only one half so O(n) = n + n/2 + n/4 = 2n = O(n)
     *
     * So how can we improve the above solution and make it O(N) guaranteed?
     * If we randomize the input, it will be guaranteed Time: O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - k;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot < index) left = pivot + 1;
            else if (pivot > index) right = pivot - 1;
            else return nums[pivot];
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        while (left <= right) {
            while (left <= right && nums[left] <= nums[pivot]) left++;
            while (left <= right && nums[right] > nums[pivot]) right--;
            if (left > right) break;
            swap(nums, left, right);
        }
        swap(nums, right, pivot);
        return right;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void shuffle(int a[]) {
        Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}
