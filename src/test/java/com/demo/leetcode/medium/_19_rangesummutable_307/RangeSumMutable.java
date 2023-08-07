package com.demo.leetcode.medium._19_rangesummutable_307;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [307. Range Sum Query - Mutable - MEDIUM](https://leetcode.com/problems/range-sum-query-mutable/)
 *
 * - option1: segment tree
 * - option2: fenwick tree (BIT binary index tree)
 * - option3: sqrt Decomposition.
 * - SIMILAR_TO: [303. Range Sum Query - Immutable - EASY](https://leetcode.com/problems/range-sum-query-immutable/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=CWDQJGaN1gY&ab_channel=TusharRoy-CodingMadeSimple
 */
public class RangeSumMutable {

    @Test
    public void test() {
        int[] arr = {1, 3, 5};
        NumArray numArray = new NumArray(arr);
        Assertions.assertEquals(9, numArray.sumRange(0, 2));
        numArray.update(1, 2);
        Assertions.assertEquals(8, numArray.sumRange(0, 2));
    }

    /**
     * Time:
     * Constructor: O(n log(n))
     * update, sumRange: O(log(n))
     * Space: O(n)
     *
     * In BIT structure, there are 2 basic operations:
     * addValue(idx, value): Add an amount of value into element at index idx (1-based indexing), time: O(logN)
     * getSum(idx): Get sum in range [0..idx] (1-based indexing), time: O(logN)
     *
     * https://leetcode.com/problems/range-sum-query-mutable/discuss/1406686/C%2B%2BJavaPython-Binary-Indexed-Tree
     * https://leetcode.com/problems/range-sum-query-mutable/solution/
     */
    class NumArray {

        BIT bit;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            bit = new BIT(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                bit.addValue(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            int diff = val - nums[index]; // get diff amount of `val` compared to current value
            bit.addValue(index + 1, diff); // add this `diff` amount at index `index+1` of BIT, plus 1 because in BIT it's 1-based indexing
            nums[index] = val; // update latest value of `nums[index]`
        }

        public int sumRange(int left, int right) {
            return bit.getSum(right + 1) - bit.getSum(left);
        }
    }

    class BIT { // one-based indexing
        int[] bit;

        BIT(int size) {
            bit = new int[size + 1];
        }

        int getSum(int idx) { // Get sum in range [1..idx]
            int sum = 0;
            for (; idx > 0; idx -= idx & (-idx)) {
                sum += bit[idx];
            }
            return sum;
        }

        int getSumRange(int left, int right) { // left, right inclusive
            return getSum(right) - getSum(left - 1);
        }

        void addValue(int idx, int val) {
            for (; idx < bit.length; idx += idx & (-idx))
                bit[idx] += val;
        }
    }
}
