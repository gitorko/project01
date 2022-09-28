package com.demo.leetcode.hard._13_findmediansortedarray_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [4. Median of Two Sorted Arrays - HARD](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 *
 * - binary search
 * - option1: merge 2 array and find median. Time: O(m+n), Space: O(m+n)
 * - option2: binary search O(log(m+n))
 * - SIMILAR_TO: [295. Find Median from Data Stream - HARD](https://leetcode.com/problems/find-median-from-data-stream/)
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
     * Time: O(log(len(m,n))
     */
    public double findMedianSortedArrays(int[] X, int[] Y) {
        if (X.length > Y.length) {
            return findMedianSortedArrays(Y, X);
        }

        int x = X.length;
        int y = Y.length;
        int low = 0;
        int high = x;
        double median = 0.0;
        while (low <= high) {
            int midX = (low + high) / 2;
            int midY = ((x + y + 1) / 2) - midX;
            int maxLeftX = (midX == 0) ? Integer.MIN_VALUE : X[midX - 1];
            int maxLeftY = (midY == 0) ? Integer.MIN_VALUE : Y[midY - 1];
            int minRightX = (midX == x) ? Integer.MAX_VALUE : X[midX];
            int minRightY = (midY == y) ? Integer.MAX_VALUE : Y[midY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //even length array
                if ((x + y) % 2 == 0) {
                    median = (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    median = Math.max(maxLeftX, maxLeftY);
                }
                break;
            } else if (maxLeftX > minRightY) {
                high = midX - 1;
            } else {
                low = midX + 1;
            }
        }
        return median;
    }
}
