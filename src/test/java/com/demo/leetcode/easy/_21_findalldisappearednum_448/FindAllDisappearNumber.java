package com.demo.leetcode.easy._21_findalldisappearednum_448;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * [448. Find All Numbers Disappeared in an Array - EASY](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
 *
 * - Math.abs
 * - SIMILAR_TO: [41. First Missing Positive - HARD](https://leetcode.com/problems/first-missing-positive/)
 * - PRACTICE:P1
 *
 * https://www.youtube.com/watch?v=re7fhVyKWZI&ab_channel=DEEPTITALESRA
 */
public class FindAllDisappearNumber {

    @Test
    public void test() {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        int expected[] = {5, 6};
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            //multiplying -1 two times can make number positive. so we do marking only once.
            if (nums[pos] > 0) {
                nums[pos] = nums[pos] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
