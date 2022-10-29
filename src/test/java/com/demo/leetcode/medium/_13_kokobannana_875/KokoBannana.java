package com.demo.leetcode.medium._13_kokobannana_875;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [875. Koko Eating Bananas - MEDIUM](https://leetcode.com/problems/koko-eating-bananas/)
 *
 * - condition length(pile) <= hours
 * - binary search, ceil
 * - SIMILAR_TO: [1011. Capacity To Ship Packages Within D Days - MEDIUM](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=U2SozAs9RzA&ab_channel=NeetCode
 */
public class KokoBannana {

    @Test
    public void test1() {
        int[] piles = {3, 6, 7, 11};
        Assertions.assertEquals(4, minEatingSpeed(piles, 8));
    }

    @Test
    public void test2() {
        int[] piles = {873375536, 395271806, 617254718, 970525912, 634754347, 824202576, 694181619, 20191396, 886462834, 442389139, 572655464, 438946009, 791566709, 776244944, 694340852, 419438893, 784015530, 588954527, 282060288, 269101141, 499386849, 846936808, 92389214, 385055341, 56742915, 803341674, 837907634, 728867715, 20958651, 167651719, 345626668, 701905050, 932332403, 572486583, 603363649, 967330688, 484233747, 859566856, 446838995, 375409782, 220949961, 72860128, 998899684, 615754807, 383344277, 36322529, 154308670, 335291837, 927055440, 28020467, 558059248, 999492426, 991026255, 30205761, 884639109, 61689648, 742973721, 395173120, 38459914, 705636911, 30019578, 968014413, 126489328, 738983100, 793184186, 871576545, 768870427, 955396670, 328003949, 786890382, 450361695, 994581348, 158169007, 309034664, 388541713, 142633427, 390169457, 161995664, 906356894, 379954831, 448138536};
        Assertions.assertEquals(46, minEatingSpeed(piles, 943223529));
    }

    /**
     * Time: O(n * log(max(n)))
     * Space: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        //range starts at 1..max(pile)
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (findHours(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findHours(int[] piles, int rate) {
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil(1.0 * p / rate);
        }
        return hours;
    }

}
