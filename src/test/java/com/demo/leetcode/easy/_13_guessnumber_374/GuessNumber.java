package com.demo.leetcode.easy._13_guessnumber_374;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [374. Guess Number Higher or Lower - EASY](https://leetcode.com/problems/guess-number-higher-or-lower/)
 *
 * - binary search
 *
 * https://www.youtube.com/watch?v=xW4QsTtaCa4&ab_channel=NeetCode
 */
public class GuessNumber {

    @Test
    public void test() {
        int n = 100;
        guess = new Random().nextInt(100);
        System.out.println("Guess: " + guess);
        Assertions.assertEquals(guess, guessNumber(n));
    }

    /**
     * Time: O(log(n))
     * Space: O(1)
     */
    int guess;

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                System.out.println("Number is: " + mid);
                return mid;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Number is: " + low);
        return low;
    }

    private int guess(int num) {
        if (num < guess) {
            return 1;
        }
        if (num > guess) {
            return -1;
        }
        return 0;
    }
}
