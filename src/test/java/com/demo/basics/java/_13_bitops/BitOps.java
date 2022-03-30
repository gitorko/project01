package com.demo.basics.java._13_bitops;

import java.util.BitSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BitOps {

    @Test
    public void test() {
        BitSet bits1 = new BitSet(4);
        BitSet bits2 = new BitSet(4);

        bits1.set(0, true);
        bits1.set(1, true);
        bits1.set(2, true);
        bits1.set(3, true);

        bits2.set(0, true);
        bits2.set(1, false);
        bits2.set(2, false);
        bits2.set(3, false);

        bits1.and(bits2);
        Assertions.assertTrue(bits1.get(0));

    }

}
