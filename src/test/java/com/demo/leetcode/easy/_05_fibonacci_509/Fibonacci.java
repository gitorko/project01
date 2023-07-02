package com.demo.leetcode.easy._05_fibonacci_509;

import java.util.concurrent.RecursiveTask;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [509. Fibonacci Number - EASY](https://leetcode.com/problems/fibonacci-number/)
 *
 * - write decision tree
 * - avoid repeated work - memoization
 * - F(n) = F(n-1) + F(n-2)
 *
 * https://www.youtube.com/watch?v=dDokMfPpfu4&ab_channel=NeetCode
 */
public class Fibonacci {

    @Test
    public void test() {
        Assertions.assertEquals(13, fib(7));
        Assertions.assertEquals(13, fibMemoization(7));
        Assertions.assertEquals(13, fibIter(7));
        Assertions.assertEquals(13, fibIterOpt(7));
        Assertions.assertEquals(13, new FibForkJoin(7).compute());
    }

    /**
     * Approach 1:
     * Top Down
     * Time: O(2^N)
     */
    public int fib(int n) {
        //base case
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Approach 2:
     * Top Down + Memoization
     * Time: O(n)
     */
    int[] dp;

    public int fibMemoization(int n) {
        dp = new int[n + 1];
        return fibMem(n);
    }

    private int fibMem(int n) {
        //base case
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibMem(n - 1) + fibMem(n - 2);
        return dp[n];
    }

    /**
     * Approach 3:
     * Bottom up iterative + Memoization
     */
    public int fibIter(int n) {
        if (n <= 1) {
            return n;
        }
        dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1] + dp[n - 2];
    }

    /**
     * Approach 3:
     * Bottom up + N Variable
     */
    public int fibIterOpt(int n) {
        if (n <= 1) {
            return n;
        }
        int prevNumber = 0;
        int nextNumber = 1;
        for (int i = 2; i < n; i++) {
            int temp = prevNumber + nextNumber;
            prevNumber = nextNumber;
            nextNumber = temp;
        }
        return prevNumber + nextNumber;
    }

    /**
     * Approach 4:
     * Using fork join
     */
    @RequiredArgsConstructor
    class FibForkJoin extends RecursiveTask<Integer> {
        final int n;

        @Override
        protected Integer compute() {
            System.out.println("Current Thread: " + Thread.currentThread().getName() + " n = " + n);
            if (n <= 1) {
                return n;
            }
            FibForkJoin f1 = new FibForkJoin(n - 1);
            f1.fork();
            FibForkJoin f2 = new FibForkJoin(n - 2);
            f2.fork();
            return f1.join() + f2.join();
        }
    }

}


