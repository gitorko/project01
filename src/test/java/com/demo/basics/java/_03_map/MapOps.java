package com.demo.basics.java._03_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-hashmap
 */
public class MapOps {

    @Test
    public void test_mapIteration() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("name_" + i, i);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void test_mapCounter() {
        List<String> names = Arrays.asList("Raj", "David", "Ron", "David", "Susan", "David");
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Assertions.assertTrue(map.containsKey("Raj"));

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (Integer value : map.values()) {
            System.out.println(value);
        }

        map.putIfAbsent("Raj", 1);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    @Test
    public void test_put() {
        //put returns previous value
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("A","1"));
        System.out.println(map.put("A","2"));
    }
}
