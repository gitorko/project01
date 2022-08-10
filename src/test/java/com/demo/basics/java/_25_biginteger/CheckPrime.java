package com.demo.basics.java._25_biginteger;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckPrime {

    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    BigInteger two = new BigInteger("2");

    @Test
    public void test() {
        Assertions.assertTrue(isPrime(new BigInteger("11")));
        Assertions.assertTrue(isPrime(new BigInteger("41")));
        Assertions.assertTrue(isPrime(new BigInteger("2917")));
        Assertions.assertFalse(isPrime(new BigInteger("10")));
    }

    private boolean isPrime(BigInteger num) {
        if (num.compareTo(one) <= 0) {
            return false;
        }
        BigInteger bigI = new BigInteger("2");
        BigInteger halfPoint = num.divide(two);
        while (bigI.compareTo(halfPoint) < 0) {
            if (num.mod(bigI).compareTo(zero) == 0) {
                return false;
            }
            bigI = bigI.add(one);
        }
        return true;
    }
}
