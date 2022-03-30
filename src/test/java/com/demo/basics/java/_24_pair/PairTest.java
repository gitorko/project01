package com.demo.basics.java._24_pair;

import java.util.AbstractMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PairTest {

    @Test
    public void test() {
        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "one");
        Integer key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + " " + value);
    }

}
