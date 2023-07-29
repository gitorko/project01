package com.demo.leetcode.hard._13_findmediansortedarray_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [4. Median of Two Sorted Arrays - HARD](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 *
 * - binary search
 * - option1: merge 2 array and find median. Time: O(m+n), Space: O(m+n)
 * - option2: binary search O(log(m+n))
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=q6IEA26hvXc&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=LPFhl65R7ww&ab_channel=TusharRoy-CodingMadeSimple
 */
public class MedianSortedArray {

    @Test
    public void test() {
        int nums1[] = {1, 3}, nums2[] = {2};
        Assertions.assertEquals(2.00000, findMedianSortedArrays(nums1, nums2));
    }

    /**
     * Time: O(log(min(m,n))
     */
    public double findMedianSortedArrays(int[] X, int[] Y) {
        if (X.length > Y.length) {
            return findMedianSortedArrays(Y, X);
        }
        int xLen = X.length;
        int yLen = Y.length;
        int left = 0;
        int right = xLen;
        double median = 0.0;
        while (left <= right) {
            int halfVal = ((xLen + yLen + 1) / 2);
            int midX = (left + right) / 2;
            int midY = halfVal - midX;
            int maxLeftX = (midX == 0) ? Integer.MIN_VALUE : X[midX - 1];
            int maxLeftY = (midY == 0) ? Integer.MIN_VALUE : Y[midY - 1];
            int minRightX = (midX == xLen) ? Integer.MAX_VALUE : X[midX];
            int minRightY = (midY == yLen) ? Integer.MAX_VALUE : Y[midY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((xLen + yLen) % 2 == 0) {
                    //even length array
                    median = (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    //odd length array
                    median = Math.max(maxLeftX, maxLeftY);
                }
                break;
            } else if (maxLeftX > minRightY) {
                right = midX - 1;
            } else {
                left = midX + 1;
            }
        }
        return median;
    }
}
