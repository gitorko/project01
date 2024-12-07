package com.demo.basics.java._29_compactnum;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class CompactNum {
    @Test
    public void test() {
        var number = 10000000;
        var f1 = NumberFormat.getCompactNumberInstance();
        var f2 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(f1.format(number));
        System.out.println(f2.format(number));
    }
}
