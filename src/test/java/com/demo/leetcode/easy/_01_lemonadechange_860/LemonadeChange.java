package com.demo.leetcode.easy._01_lemonadechange_860;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [860. Lemonade Change - EASY](https://leetcode.com/problems/lemonade-change/)
 *
 * - keep a counter for each currency
 */
public class LemonadeChange {

    @Test
    public void test() {
        int bills1[] = {5, 5, 5, 10, 20};
        Assertions.assertTrue(lemonadeChange(bills1));
        int bills2[] = {20, 10, 5, 5, 5};
        Assertions.assertFalse(lemonadeChange(bills2));
        int bills3[] = {5, 5, 10, 10, 5};
        Assertions.assertTrue(lemonadeChange(bills3));
        int bills4[] = {10, 10};
        Assertions.assertFalse(lemonadeChange(bills4));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     * if (customer pays with $5) five++;
     * if (customer pays with $10) ten++, five--;
     * if (customer pays with $20) ten--, five-- or five -= 3;
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
